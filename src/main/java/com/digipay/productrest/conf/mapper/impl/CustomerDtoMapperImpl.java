package com.digipay.productrest.conf.mapper.impl;

import com.digipay.productrest.conf.mapper.CustomerDtoMapper;
import com.digipay.productrest.dto.CustomerDto;
import com.digipay.productrest.entity.Customer;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-20T21:07:28+0330",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_341 (Oracle Corporation)"
)
@Component
public class CustomerDtoMapperImpl implements CustomerDtoMapper {

    @Override
    public Customer dtoToCustomerMapper(CustomerDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( addressDto.getCustomerId() );
        customer.setNationalId( addressDto.getNationalId() );
        customer.setFirstName( addressDto.getFirstName() );
        customer.setLastName( addressDto.getLastName() );
        customer.setBirthDate( addressDto.getBirthDate() );
        customer.setBirthCertificateNo( addressDto.getBirthCertificateNo() );
        customer.setBirthPlace( addressDto.getBirthPlace() );
        customer.setContactInfo( addressDto.getContactInfo() );

        return customer;
    }

    @Override
    public CustomerDto customerToDtoMapper(Customer address) {
        if ( address == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerId( address.getCustomerId() );
        customerDto.setNationalId( address.getNationalId() );
        customerDto.setFirstName( address.getFirstName() );
        customerDto.setLastName( address.getLastName() );
        customerDto.setBirthDate( address.getBirthDate() );
        customerDto.setBirthCertificateNo( address.getBirthCertificateNo() );
        customerDto.setBirthPlace( address.getBirthPlace() );
        customerDto.setContactInfo( address.getContactInfo() );

        return customerDto;
    }
}
