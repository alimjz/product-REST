package com.digipay.productrest.controller;

import com.digipay.productrest.conf.ApplicationConstants;
import com.digipay.productrest.dto.BaseResponse;
import com.digipay.productrest.dto.OrderDto;
import com.digipay.productrest.entity.Order;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Creates new Order in system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Insert an Order Instance",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Security Basic Auth needed", content = @Content)})
    @PostMapping("/orders/")
    public ResponseEntity<BaseResponse<Order>> createOrder(@RequestBody OrderDto orderDto){
        Order savedOrder = orderService.createOrder(orderDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOrder.getOrderId())
                        .toUri()).
                body(new BaseResponse<>(HttpStatus.CREATED.value(), ApplicationConstants.SUCCESS));
    }

}
