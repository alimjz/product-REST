package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.model.dto.WarehouseDto;
import com.digipay.productrest.model.entity.Warehouse;

//@Mapper(componentModel = "spring")
public interface WarehouseDtoMapper {
    Warehouse dtoToWarehouseMapper(WarehouseDto warehouseDto);

    WarehouseDto warehouseToDtoMapper(Warehouse warehouse);
}
