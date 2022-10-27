package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.CustomerDtoMapper;
import com.digipay.productrest.exception.CustomerExistException;
import com.digipay.productrest.exception.ErrorConstants;
import com.digipay.productrest.model.dto.CustomerDto;
import com.digipay.productrest.model.entity.Customer;
import com.digipay.productrest.repository.CustomerRepository;
import com.digipay.productrest.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoMapper customerMapper;

    private Set<String> customerCache = new HashSet<>();

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerDtoMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer registerCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.dtoToCustomerMapper(customerDto);
        if (!customerCache.contains(customer.getNationalId())){
            customerCache.add(customer.getNationalId());
            return customerRepository.save(customer);
        }
        throw new CustomerExistException(ErrorConstants.DUPLICATE_CUSTOMER_REGISTRATION);

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
