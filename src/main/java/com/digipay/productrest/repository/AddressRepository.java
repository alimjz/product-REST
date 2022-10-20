package com.digipay.productrest.repository;

import com.digipay.productrest.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,String> {
}
