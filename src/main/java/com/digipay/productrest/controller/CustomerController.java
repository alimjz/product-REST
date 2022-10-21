package com.digipay.productrest.controller;

import com.digipay.productrest.conf.ApplicationConstants;
import com.digipay.productrest.dto.BaseResponse;
import com.digipay.productrest.dto.CustomerDto;
import com.digipay.productrest.entity.Customer;
import com.digipay.productrest.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.digipay.productrest.conf.ApplicationConstants.*;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "register customer to the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = BADREQUEST,
                    content = @Content),
            @ApiResponse(responseCode = "401", description = AUTHENTICATION, content = @Content)})
    @PostMapping("/customers")
    public ResponseEntity<BaseResponse<Customer>> createCustomer(@RequestBody @Valid CustomerDto customerDto){
        Customer customer = customerService.registerCustomer(customerDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getCustomerId())
                .toUri()).body(new BaseResponse<>(HttpStatus.CREATED.value(),
                ApplicationConstants.SUCCESS));
    }

    @Operation(summary = "Query All existed customers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = FOUND,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = BADREQUEST,
                    content = @Content),
            @ApiResponse(responseCode = "401", description = AUTHENTICATION, content = @Content)})
    @GetMapping("/customers")
    public ResponseEntity<BaseResponse<List<Customer>>> findAllCustomers() {
        List<Customer> customerList = customerService.findAllCustomers();
        if (customerList.isEmpty()) {
            return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), ApplicationConstants.NO_CONTENT,
                    null, null));
        }
        return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.OK.value(), FOUND,
                null, customerList));
    }

    @Operation(summary = "Query customer by NationalId.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = FOUND,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = BADREQUEST,
                    content = @Content),
            @ApiResponse(responseCode = "401", description = AUTHENTICATION, content = @Content)})

    @GetMapping("/customers/searchbynationalid/{id}")
    public ResponseEntity<BaseResponse<Optional<Customer>>> findCustomerByNationalId(@PathVariable String id) {
        Optional<Customer> customer = customerService.findCustomerByCertificate(id);
        if (!customer.isPresent()) {
            return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), ApplicationConstants.NO_CONTENT,
                    null, null));
        }
        return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.OK.value(), FOUND,
                null, customer));
    }

    @Operation(summary = "Query customer by Customer ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = FOUND,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "400", description = BADREQUEST,
                    content = @Content),
            @ApiResponse(responseCode = "401", description = AUTHENTICATION, content = @Content)})
    @GetMapping("/customers/{id}")
    public ResponseEntity<BaseResponse<Optional<Customer>>> findCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        if (!customer.isPresent()) {
            return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.NOT_FOUND.value(), ApplicationConstants.NO_CONTENT,
                    null, null));
        }
        return ResponseEntity.ok().body(new BaseResponse<>(HttpStatus.OK.value(), FOUND,
                null, customer));
    }
}
