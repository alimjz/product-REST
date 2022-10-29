package com.digipay.productrest.model.dto;

import com.digipay.productrest.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private AddressType addressType;
    @NotBlank(message = "Province is Mandatory.")
    private String province;
    @NotBlank(message = "City is Mandatory.")
    private String city;
    @NotBlank(message = "Street is Mandatory.")
    private String street;
    private String buildingNo;
    @Size(min = 10, max = 10, message = "Postal code is not correct.")
    private String postalCode;

}
