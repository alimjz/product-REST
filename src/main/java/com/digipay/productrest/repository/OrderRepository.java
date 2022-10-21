package com.digipay.productrest.repository;

import com.digipay.productrest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    int countOrdersByCustomer_CustomerId(String customerId);
}
