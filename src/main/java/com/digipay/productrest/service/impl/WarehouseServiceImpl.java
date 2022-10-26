package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.WarehouseDtoMapper;
import com.digipay.productrest.model.dto.WarehouseDto;
import com.digipay.productrest.model.entity.Warehouse;
import com.digipay.productrest.repository.WarehouseRepository;
import com.digipay.productrest.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;

    private WarehouseDtoMapper warehouseDtoMapper;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Warehouse saveWarehouse(WarehouseDto warehouseDto) {
        return warehouseRepository.save(warehouseDtoMapper.dtoToWarehouseMapper(warehouseDto));
    }

    @Override
    public Optional<Warehouse> findWarehouseById(String id) {
        return Optional.empty();
    }

    @Override
    public Page<Warehouse> findAllWarehousePageable(Pageable pageable) {
        return null;
    }
}
