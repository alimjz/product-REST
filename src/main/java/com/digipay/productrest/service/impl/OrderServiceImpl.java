package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.OrderDtoMapper;
import com.digipay.productrest.dto.OrderDto;
import com.digipay.productrest.entity.Customer;
import com.digipay.productrest.entity.Invoice;
import com.digipay.productrest.entity.Order;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.repository.OrderRepository;
import com.digipay.productrest.service.CustomerService;
import com.digipay.productrest.service.InvoiceService;
import com.digipay.productrest.service.OrderService;
import com.digipay.productrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final InvoiceService invoiceService;
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderDtoMapper orderDtoMapper;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, InvoiceService invoiceService
            , CustomerService customerService, ProductService productService, OrderDtoMapper orderDtoMapper) {
        this.orderRepository = orderRepository;
        this.invoiceService = invoiceService;
        this.customerService = customerService;
        this.productService = productService;
        this.orderDtoMapper = orderDtoMapper;
    }

    @Override
    public Order createOrder(OrderDto orderDto) {
        Optional<Customer> customer = customerService.findCustomerById(orderDto.getCustomerId());
        List<Product> products = productService.findProductsByProductIds(orderDto.getProductsId());
        Invoice invoice = invoiceService.calculateInvoice(products,
                orderRepository.countOrdersByCustomer_CustomerId(orderDto.getCustomerId()));
        return orderRepository.save(orderDtoMapper.dtoToOrderMapper(orderDto, products, customer, invoice));
    }


    @Override
    public List<Order> queryAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> queryOrderById(Long id) {
        return orderRepository.findById(id);
    }
}
