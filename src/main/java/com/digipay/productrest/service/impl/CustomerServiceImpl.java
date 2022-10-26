package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.CustomerDtoMapper;
import com.digipay.productrest.model.dto.CustomerDto;
import com.digipay.productrest.model.entity.Customer;
import com.digipay.productrest.repository.CustomerRepository;
import com.digipay.productrest.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerDtoMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer registerCustomer(CustomerDto customerDto) {
        return customerRepository.save(customerMapper.dtoToCustomerMapper(customerDto));
    }

    @Override
    public Page<Customer> findAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public Optional<Customer> findCustomerByCertificate(String id) {
        return customerRepository.findByNationalId(id);
    }

    public Optional<Customer> findCustomerById(String id) {
        return customerRepository.findById(id);
    }
}
