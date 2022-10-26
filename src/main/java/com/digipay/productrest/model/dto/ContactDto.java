package com.digipay.productrest.model.dto;

import com.digipay.productrest.model.entity.ContactType;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class ContactDto {

    private ContactType contactType;
    @NotNull(message = "Phone number is mandatory.")
    private String phoneNumber;
    @Email(message = "The Email format is not correct.")
    private String email;
    private AddressDto address;

}
