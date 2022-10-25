package com.digipay.productrest.service;

import com.digipay.productrest.model.dto.AddressDto;
import com.digipay.productrest.model.entity.Address;

public interface AddressService {
    Address saveAddress(AddressDto addressDto);
}
