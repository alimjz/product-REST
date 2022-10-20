package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.dto.AddressDto;
import com.digipay.productrest.entity.Address;

//@Mapper(componentModel = "spring")
public interface AddressDtoMapper {
    Address dtoToAddressMapper(AddressDto addressDto);
    AddressDto addressToDtoMapper(Address address);
}
