package com.digipay.productrest.dto;

import com.digipay.productrest.entity.Customer;
import com.digipay.productrest.entity.Invoice;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.enums.BusinessCode;
import com.digipay.productrest.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    @JsonIgnore
    private Long orderId;
    @NotBlank(message = "The Product field should not be Empty.")
    private List<Product> product;
    private LocalDateTime createDate = LocalDateTime.now();
    private OrderStatus status = OrderStatus.INPROGRESS;
    private BusinessCode businessCode = BusinessCode.SALE;
    private LocalDateTime statusDate = LocalDateTime.now();
    @JsonIgnore
    private Invoice invoice;
    private Customer customer;


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

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
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
