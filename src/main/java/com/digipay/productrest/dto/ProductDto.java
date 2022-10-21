package com.digipay.productrest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto {
    @JsonIgnore
    private Long prodId;
    @NotBlank(message = "The Prod Code should not blank.")
    private String prodCode;
    @NotBlank(message = "The Product Name should not blank.")
    private String prodName;
    @NotNull(message = "The Sell Price Should not be Null or Empty.")
    private Double buyPrice;
    @NotNull(message = "The Sell Price Should not be Null or Empty.")
    private Double sellPrice;
    private String model;
    private String prodType;
    private String prodSubType;
    @Min(1)
    private Integer quants;

    private String warehouseId;// TODO: 10/23/2022 check the warehouse exists.



    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdSubType() {
        return prodSubType;
    }

    public void setProdSubType(String prodSubType) {
        this.prodSubType = prodSubType;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getQuants() {
        return quants;
    }

    public void setQuants(Integer quants) {
        this.quants = quants;
    }
}
