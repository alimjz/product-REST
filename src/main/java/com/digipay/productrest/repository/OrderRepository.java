package com.digipay.productrest.repository;

import com.digipay.productrest.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    int countOrdersByCustomer_CustomerId(String customerId);
}
