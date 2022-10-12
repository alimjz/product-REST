package com.digipay.productrest.dto;

import com.digipay.productrest.entity.Product;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class BaseResponse {

    private int  status;
    private String description;

    private Map<String, String> errors;

    public BaseResponse(int  status, String description) {
        this.status = status;
        this.description = description;
    }

    public BaseResponse(int  status, String description,Map<String,String> errors) {
        this.status = status;
        this.description = description;
        this.errors = errors;
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
