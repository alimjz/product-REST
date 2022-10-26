package com.digipay.productrest.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class OrderDto {

    @JsonIgnore
    private Long orderId;
    @NotBlank(message = "The Product field should not be Empty.")
    private Set<Long> productsId;

    private String customerId;


}
