package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.AddressDtoMapper;
import com.digipay.productrest.dto.AddressDto;
import com.digipay.productrest.entity.Address;
import com.digipay.productrest.repository.AddressRepository;
import com.digipay.productrest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressDtoMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, AddressDtoMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public Address saveAddress(AddressDto addressDto) {
        return addressRepository.save(addressMapper.dtoToAddressMapper(addressDto));
    }
}
