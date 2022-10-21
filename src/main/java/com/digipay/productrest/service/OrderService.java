package com.digipay.productrest.service;

import com.digipay.productrest.dto.OrderDto;
import com.digipay.productrest.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(OrderDto orderDto) ;
    List<Order> queryAllOrders();
    Optional<Order> queryOrderById(Long id);
}
