package com.digipay.productrest.controller;

import com.digipay.productrest.conf.DigipayConstants;
import com.digipay.productrest.dto.BaseResponse;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.service.ProductService;
import com.digipay.productrest.service.ProductServiceImpl;

import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private ProductService prodService;
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService prodService) {
        this.prodService = prodService;
    }

    @PostMapping("/product")
    public ResponseEntity<?> storeProduct(@RequestBody @Valid Product product){
            Product saveProduct = prodService.saveProduct(product);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveProduct.getProdId())
                    .toUri();
            log.info("Product Saved.");
            return ResponseEntity.created(location).body(new BaseResponse(HttpStatus.CREATED.value(),
                            DigipayConstants.SUCCESS));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
                DigipayConstants.BADREQUEST,errors));
    }


}
