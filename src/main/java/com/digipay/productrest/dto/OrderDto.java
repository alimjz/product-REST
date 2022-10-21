package com.digipay.productrest.dto;

import com.digipay.productrest.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class OrderDto {

    @JsonIgnore
    private Long orderId;
    @NotBlank(message = "The Product field should not be Empty.")
    private List<Product> product;

    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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


}
