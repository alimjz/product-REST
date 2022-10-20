package com.digipay.productrest.service.impl;

import com.digipay.productrest.entity.Customer;
import com.digipay.productrest.entity.Order;
import com.digipay.productrest.repository.CustomerRepository;
import com.digipay.productrest.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Order order) {
        return customerRepository.save(order.getCustomer());
    }
}
