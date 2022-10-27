package com.digipay.productrest.exception;

public class CustomerExistException extends RuntimeException {
    public CustomerExistException(String message) {
        super(message);
    }
}
