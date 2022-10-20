package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.impl.OrderDtoMapperImpl;
import com.digipay.productrest.dto.OrderDto;
import com.digipay.productrest.entity.Order;
import com.digipay.productrest.repository.OrderRepository;
import com.digipay.productrest.service.CustomerService;
import com.digipay.productrest.service.InvoiceService;
import com.digipay.productrest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDtoMapperImpl orderMapper;

    private InvoiceService invoiceService;
    private CustomerService customerService;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDtoMapperImpl orderMapper, InvoiceService invoiceService
    ,CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.invoiceService = invoiceService;
        this.customerService = customerService;
    }

    @Override
    public Order createOrder(OrderDto orderDto) {
        Order order = orderMapper.dtoToOrderMapper(orderDto);
        customerService.saveCustomer(order);
        invoiceService.saveInvoice(order);
        return orderRepository.save(order);
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
