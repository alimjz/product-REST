package com.digipay.productrest.exception;

public class CustomerExistException extends Exception {
    public CustomerExistException(String message) {
        super("Customer Already Exists. Registration is not Allowed.");
    }
}
