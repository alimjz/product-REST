package com.digipay.productrest.dto;

import java.util.Map;

public class BaseResponse<T> {

    private int status;
    private String description;

    private Map<String, String> errors;

    private T response;



    public BaseResponse(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public BaseResponse(int status, String description, Map<String, String> errors) {
        this(status,description);
        this.errors = errors;
    }

    public BaseResponse(int status, String description, Map<String,String> errors,T response){
        this(status,description,errors);
        this.response = response;
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

    public T getResponse(){
        return this.response;
    }

    public void setResponse(T response){
        this.response = response;
    }

}
