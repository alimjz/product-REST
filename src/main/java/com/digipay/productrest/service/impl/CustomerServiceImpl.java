package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.CustomerDtoMapper;
import com.digipay.productrest.dto.CustomerDto;
import com.digipay.productrest.entity.Customer;
import com.digipay.productrest.exception.ErrorConstants;
import com.digipay.productrest.repository.CustomerRepository;
import com.digipay.productrest.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
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
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerByCertificate(String id){
        return customerRepository.findByNationalId(id);
    }

    public Optional<Customer> findCustomerById(String id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return customer;
        }
        throw new NotFoundException(ErrorConstants.CUSTOMER_NOT_FOUND);
    }
}
