package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.OrderDtoMapper;
import com.digipay.productrest.enums.BusinessCode;
import com.digipay.productrest.exception.ProductNotFoundException;
import com.digipay.productrest.model.dto.OrderDto;
import com.digipay.productrest.model.entity.Customer;
import com.digipay.productrest.model.entity.Invoice;
import com.digipay.productrest.model.entity.Order;
import com.digipay.productrest.model.entity.Product;
import com.digipay.productrest.repository.OrderRepository;
import com.digipay.productrest.service.CustomerService;
import com.digipay.productrest.service.InvoiceService;
import com.digipay.productrest.service.OrderService;
import com.digipay.productrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

import static com.digipay.productrest.exception.ErrorConstants.CUSTOMER_NOT_FOUND;
import static com.digipay.productrest.exception.ErrorConstants.PRODUCT_NOT_FOUND;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final InvoiceService invoiceService;
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderDtoMapper orderMapper;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, InvoiceService invoiceService
            , CustomerService customerService, ProductService productService, OrderDtoMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.invoiceService = invoiceService;
        this.customerService = customerService;
        this.productService = productService;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Order createSalesOrder(OrderDto orderDto) {
        Optional<Customer> customer = customerService.findCustomerById(orderDto.getCustomerId());
        List<Product> products = productService.findNonZeroQuantsProducts(orderDto.getProductsId());
        Invoice invoice = invoiceService.calculateInvoice(products, orderDto.getCustomerId());
        if (!customer.isPresent()) {
            throw new NotFoundException(CUSTOMER_NOT_FOUND);
        } else if (products.size() != orderDto.getProductsId().size()) {
            throw new ProductNotFoundException(PRODUCT_NOT_FOUND);
        }
        Order order = orderMapper.convertDtoToOrder(orderDto, products, customer, invoice, BusinessCode.SALE);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> queryAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> queryOrderById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public int countCustomerOrders(String id) {
        return orderRepository.countOrdersByCustomer_CustomerId(id);
    }
}
