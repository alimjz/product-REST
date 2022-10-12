package com.digipay.productrest.controller;

import com.digipay.productrest.conf.DigipayConstants;
import com.digipay.productrest.dto.BaseResponse;
import com.digipay.productrest.dto.ProductDto;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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
    @ApiOperation(value = "insert product data into database",
            authorizations = {@Authorization(value = "basicAuth")})
    public ResponseEntity<BaseResponse> storeProduct(@RequestBody @Valid ProductDto productDto) {

        Product saveProduct = prodService.saveProduct(productDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveProduct.getProdId())
                .toUri();
        log.info("Product Saved.");
        return ResponseEntity.created(location).body(new BaseResponse(HttpStatus.CREATED.value(),
                DigipayConstants.SUCCESS));
    }
}
