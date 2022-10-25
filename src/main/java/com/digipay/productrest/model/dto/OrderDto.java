package com.digipay.productrest.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class OrderDto {

    @JsonIgnore
    private Long orderId;
    @NotBlank(message = "The Product field should not be Empty.")
    private Set<Long> productsId;

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

    public Set<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(Set<Long> productsId) {
        this.productsId = productsId;
    }
}
