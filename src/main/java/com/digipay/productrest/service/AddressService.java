package com.digipay.productrest.service;

import com.digipay.productrest.dto.AddressDto;
import com.digipay.productrest.entity.Address;

public interface AddressService {
    Address saveAddress(AddressDto addressDto);
}
