package com.digipay.productrest.dto;

import com.digipay.productrest.entity.Product;

import java.util.List;
import java.util.Map;

public class BaseResponse {

    private int status;
    private String description;

    private Map<String, String> errors;

    private List<Product> products;

    public BaseResponse(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public BaseResponse(int status, String description, Map<String, String> errors) {
        this(status,description);
        this.errors = errors;
    }

    public BaseResponse(int status, String description, Map<String,String> errors,List<Product> products){
        this(status,description,errors);
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
