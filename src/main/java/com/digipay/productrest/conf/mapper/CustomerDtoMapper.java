package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.dto.CustomerDto;
import com.digipay.productrest.entity.Customer;

//@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {
    Customer dtoToCustomerMapper(CustomerDto addressDto);

    CustomerDto customerToDtoMapper(Customer address);
}
