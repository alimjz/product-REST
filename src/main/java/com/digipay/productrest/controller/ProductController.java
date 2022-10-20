package com.digipay.productrest.controller;

import com.digipay.productrest.conf.ApplicationConstants;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService prodService;
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
    public ResponseEntity<BaseResponse<Product>> storeProduct(@RequestBody @Valid ProductDto productDto) {

        Product savedProduct = prodService.saveProduct(productDto);
        log.info("Product Saved.");
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProduct.getProdId())
                .toUri()).body(new BaseResponse<>(HttpStatus.CREATED.value(),
                ApplicationConstants.SUCCESS));
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
    public ResponseEntity<BaseResponse<List<Product>>> findAllProducts() {
        List<Product> result = prodService.findAllProductsList();
        if (result.isEmpty()) {
            return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), ApplicationConstants.NO_CONTENT,
                    null, null));
        }
        return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.OK.value(), ApplicationConstants.FOUND,
                null, result));
    }

    @Operation(summary = "Query product based on entered ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Security Basic Auth needed", content = @Content)})
    @GetMapping("/products/{id}")
    public ResponseEntity<BaseResponse<Optional<Product>>> findProductById(@PathVariable(name = "id") Long id) {
        Optional<Product> result = prodService.findProductById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.FOUND.value(), ApplicationConstants.FOUND,
                    null,result));
        }
        return new ResponseEntity<>(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), ApplicationConstants.FOUND,
                null,null),HttpStatus.NOT_FOUND);
    }
}
