package com.digipay.productrest.repository;

import com.digipay.productrest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Optional<Customer> findByNationalId(String id);
}
