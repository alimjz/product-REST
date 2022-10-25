package com.digipay.productrest.service;

import com.digipay.productrest.model.dto.OrderDto;
import com.digipay.productrest.model.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createSalesOrder(OrderDto orderDto);

    List<Order> queryAllOrders();

    Optional<Order> queryOrderById(Long id);

    int countCustomerOrders(String id);
}
