package com.digipay.productrest.service;

import com.digipay.productrest.entity.Customer;
import com.digipay.productrest.entity.Order;

public interface CustomerService {
    Customer saveCustomer(Order order);
}
