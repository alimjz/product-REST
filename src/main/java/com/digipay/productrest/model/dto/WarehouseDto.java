package com.digipay.productrest.model.dto;

import lombok.Data;

@Data
public class WarehouseDto {
    private String warehouseName;
    private AddressDto address;
}
