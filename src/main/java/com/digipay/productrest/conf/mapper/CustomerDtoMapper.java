package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.model.dto.CustomerDto;
import com.digipay.productrest.model.entity.Customer;

//@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {
    Customer dtoToCustomerMapper(CustomerDto customerDto);

    CustomerDto customerToDtoMapper(Customer customer);
}
