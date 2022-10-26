package com.digipay.productrest.service;

import com.digipay.productrest.model.dto.WarehouseDto;
import com.digipay.productrest.model.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface WarehouseService {

    Warehouse saveWarehouse(WarehouseDto warehouseDto);

    Optional<Warehouse> findWarehouseById(String id);

    Page<Warehouse> findAllWarehousePageable(Pageable pageable);
}
