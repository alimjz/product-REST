package com.digipay.productrest.entity;

import com.digipay.productrest.enums.BusinessCode;
import com.digipay.productrest.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_Orders")
public class Order {
    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long orderId;
    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "order")
    private List<Product> product;
    @NotNull
    private LocalDateTime createDate ;
    private OrderStatus status;
    private BusinessCode businessCode;
    private LocalDateTime statusDate ;
    @OneToOne(cascade = CascadeType.ALL,targetEntity = Invoice.class,mappedBy = "order")
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @PrePersist
    public void prePersistInitialize(){
        this.createDate = LocalDateTime.now();
        this.statusDate = LocalDateTime.now();
    }
    @PostUpdate
    public void update(){
        this.statusDate = LocalDateTime.now();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }



    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BusinessCode getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(BusinessCode businessCode) {
        this.businessCode = businessCode;
    }

    public LocalDateTime getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(LocalDateTime statusDate) {
        this.statusDate = statusDate;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
