package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.model.dto.AddressDto;
import com.digipay.productrest.model.entity.Address;

//@Mapper(componentModel = "spring")
public interface AddressDtoMapper {
    Address dtoToAddressMapper(AddressDto addressDto);

    AddressDto addressToDtoMapper(Address address);
}
