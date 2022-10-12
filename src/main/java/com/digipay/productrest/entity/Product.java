package com.digipay.productrest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private Long prodId;
    @NotNull(message = "The Product Code Should not be Null or Empty.")
    @NotEmpty(message = "The Product Code Should not be Null or Empty.")
    @NotBlank(message = "The Prod Code should not blank.")
    private String prodCode;
    @NotNull(message = "The Sell Price Should not be Null or Empty.")
    @NotEmpty(message = "The Product Name Should not be Null or Empty.")
    @NotBlank(message = "The Product Name should not blank.")
    private String prodName;
    @NotNull(message = "The Sell Price Should not be Null or Empty.")
    @NotEmpty(message = "The Buy Price Should not be Null or Empty.")
    private String buyPrice;
    @NotNull(message = "The Sell Price Should not be Null or Empty.")
    @NotEmpty(message = "The Sell Price Should not be Null or Empty.")
    private String sellPrice;
    private String model;
    private String prodType;
    private String prodSubType;

    public Product() {
    }

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

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
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
}
