package com.digipay.productrest.exception;

public class ErrorConstants {
    private ErrorConstants() {
    }

    public static final String METHOD_NOT_ALLOWED ="method not allowed";
    public static final String DUPLICATE_CUSTOMER_REGISTRATION = "Customer Already Exists. Registration is not Allowed.";
    public static final String NOT_FOUND = "Entered Customer Id or Product Id Not Found.";
    public static final String PRODUCT_NOT_FOUND = "Product Id Not Found or is not Available to Sell.";
    public static final String CUSTOMER_NOT_FOUND = "Customer Id Not Found.";
}
