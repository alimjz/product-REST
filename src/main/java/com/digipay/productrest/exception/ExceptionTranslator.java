package com.digipay.productrest.exception;

import com.digipay.productrest.conf.ApplicationConstants;
import com.digipay.productrest.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.Map;

import static com.digipay.productrest.exception.ErrorConstants.*;

@RestControllerAdvice
public class ExceptionTranslator {
    private static final String TITLE = "description";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Map<String,String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(new BaseResponse<>(HttpStatus.BAD_REQUEST.value(),
                ApplicationConstants.BADREQUEST, errors));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<BaseResponse<Map<String,String>>> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        Map<String, String> map = new HashMap<>();
        map.put(TITLE, METHOD_NOT_ALLOWED);
        return ResponseEntity.badRequest().body(new BaseResponse<>(HttpStatus.METHOD_NOT_ALLOWED.value(),
                ApplicationConstants.BADREQUEST, map));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomerExistException.class)
    public ResponseEntity<BaseResponse<Map<String,String>>> customerDuplicationHandler(CustomerExistException ex) {
        Map<String, String> map = new HashMap<>();
        map.put(TITLE, DUPLICATE_CUSTOMER_REGISTRATION);
        return ResponseEntity.badRequest().body(new BaseResponse<>(HttpStatus.METHOD_NOT_ALLOWED.value(),
                ApplicationConstants.BADREQUEST, map));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<Map<String,String>>> elementNotFound(NotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put(TITLE,NOT_FOUND);
        return ResponseEntity.badRequest().body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(),
                NOT_FOUND, map));
    }

}
