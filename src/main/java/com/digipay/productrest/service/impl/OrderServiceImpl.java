package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.InvoiceDtoMapper;
import com.digipay.productrest.dto.OrderDto;
import com.digipay.productrest.entity.Customer;
import com.digipay.productrest.entity.Order;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.entity.SalesItem;
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
    private final InvoiceDtoMapper invoiceDtoMapper;

    private InvoiceService invoiceService;
    private CustomerService customerService;

    private ProductService productService;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, InvoiceDtoMapper invoiceDtoMapper, InvoiceService invoiceService
    , CustomerService customerService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.invoiceDtoMapper = invoiceDtoMapper;
        this.invoiceService = invoiceService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Override
    public Order createOrder(OrderDto orderDto) {
        Optional<Customer> customer = customerService.findCustomerById(orderDto.getCustomerId());
        List<Product> products = productService.findAllProductsList();
        Order order = new Order();
        SalesItem salesItem = new SalesItem();
        salesItem.setProducts(products);
        if (customer.isPresent()){
            order.setSalesItem(salesItem);
            order.setInvoice(invoiceService.calculateInvoice(products,
                    orderRepository.countOrdersByCustomer_CustomerId(orderDto.getCustomerId())));
            order.setCustomer(customer.get());
            orderRepository.save(order);
        }
        return order;
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
