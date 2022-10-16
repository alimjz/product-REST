package com.digipay.productrest.controller;

import com.digipay.productrest.conf.DigipayConstants;
import com.digipay.productrest.dto.BaseResponse;
import com.digipay.productrest.dto.ProductDto;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private ProductService prodService;
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService prodService) {
        this.prodService = prodService;
    }


    @PostMapping("/products")
    @Operation(summary = "Insert a Product record based on Inputs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Insert a Product Instance",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Security Basic Auth needed", content = @Content)})
    public ResponseEntity<BaseResponse> storeProduct(@RequestBody @Valid ProductDto productDto) {

        Product saveProduct = prodService.saveProduct(productDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveProduct.getProdId())
                .toUri();
        log.info("Product Saved.");
        return ResponseEntity.created(location).body(new BaseResponse(HttpStatus.CREATED.value(),
                DigipayConstants.SUCCESS));
    }

    @Operation(summary = "Query List of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Products found.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Security Basic Auth needed", content = @Content)})
    @GetMapping("/products")
    public ResponseEntity<BaseResponse> findAllProducts(){
        List<Product> result = prodService.findAllProductsList();
        if (prodService.findAllProductsList().isEmpty()){
            return ResponseEntity.ok().body(new BaseResponse(HttpStatus.NO_CONTENT.value(), DigipayConstants.NO_CONTENT,
                    null));
        }
        return ResponseEntity.ok().body(new BaseResponse(HttpStatus.OK.value(), DigipayConstants.FOUND,
                null,result));
    }
}
