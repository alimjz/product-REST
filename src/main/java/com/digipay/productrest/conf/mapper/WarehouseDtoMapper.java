package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.dto.WarehouseDto;
import com.digipay.productrest.entity.Warehouse;

//@Mapper(componentModel = "spring")
public interface WarehouseDtoMapper {
    Warehouse dtoToWarehouseMapper(WarehouseDto warehouseDto);

    WarehouseDto warehouseToDtoMapper(Warehouse warehouse);
}
