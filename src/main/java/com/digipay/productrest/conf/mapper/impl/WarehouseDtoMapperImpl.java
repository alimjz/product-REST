package com.digipay.productrest.conf.mapper.impl;

import com.digipay.productrest.conf.mapper.WarehouseDtoMapper;
import com.digipay.productrest.dto.WarehouseDto;
import com.digipay.productrest.entity.Warehouse;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-20T21:07:27+0330",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_341 (Oracle Corporation)"
)
@Component
public class WarehouseDtoMapperImpl implements WarehouseDtoMapper {

    @Override
    public Warehouse dtoToWarehouseMapper(WarehouseDto warehouseDto) {
        if ( warehouseDto == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        warehouse.setWarehouseId( warehouseDto.getWarehouseId() );
        warehouse.setWarehouseName( warehouseDto.getWarehouseName() );
        warehouse.setAddress( warehouseDto.getAddress() );

        return warehouse;
    }

    @Override
    public WarehouseDto warehouseToDtoMapper(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        WarehouseDto warehouseDto = new WarehouseDto();

        warehouseDto.setWarehouseId( warehouse.getWarehouseId() );
        warehouseDto.setWarehouseName( warehouse.getWarehouseName() );
        warehouseDto.setAddress( warehouse.getAddress() );

        return warehouseDto;
    }
}
