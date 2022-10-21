package com.digipay.productrest.service;

import com.digipay.productrest.dto.CustomerDto;
import com.digipay.productrest.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer registerCustomer(CustomerDto customerDto);
    List<Customer> findAllCustomers();

    Optional<Customer> findCustomerByCertificate(String id);

    Optional<Customer> findCustomerById(String id);
}
