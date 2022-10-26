package com.digipay.productrest.service;

import com.digipay.productrest.model.dto.CustomerDto;
import com.digipay.productrest.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {
    Customer registerCustomer(CustomerDto customerDto);

    Page<Customer> findAllCustomers(Pageable pageable);

    Optional<Customer> findCustomerByCertificate(String id);

    Optional<Customer> findCustomerById(String id);
}
