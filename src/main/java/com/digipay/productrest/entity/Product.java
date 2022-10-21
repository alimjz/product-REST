package com.digipay.productrest.entity;

import com.digipay.productrest.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private Long prodId;

    @NotBlank(message = "The Prod Code should not be null or Empty.")
    private String prodCode;

    @NotBlank(message = "The Product Name should not be null or Empty.")
    private String prodName;

    @NotNull(message = "The Product buyPrice should not be null or Empty.")
    private Double buyPrice;
    @NotNull(message = "The Product sellPrice should not be null or Empty.")
    private Double sellPrice;
    @Column(name = "STATUS")
    private ProductStatus status ;
    private String model;
    private String prodType;
    private String prodSubType;
    @OneToOne
    @JoinColumn(name = "WAREHOUSE_ID")
    @JsonIgnore
    private Warehouse warehouse;

    @Column(name = "QUANTITY")
    private int quants;


    @PrePersist
    public void initialize(){
        this.status = ProductStatus.AVAILABLE;
    }

    public int getQuants() {
        return quants;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public void setQuants(int quants) {
        this.quants = quants;
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

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
