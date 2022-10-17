package com.digipay.productrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "TBL_WAREHOUSE")
public class Warehouse {
    @Id
    @Column(name = "WAREHOUSE_ID")
    private String warehouseId;
    private String warehouseName;
    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
