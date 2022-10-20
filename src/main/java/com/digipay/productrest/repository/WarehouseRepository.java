package com.digipay.productrest.repository;

import com.digipay.productrest.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse,String> {
}
