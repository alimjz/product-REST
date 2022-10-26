package com.digipay.productrest.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CustomerDto {
    @JsonIgnore
    private String customerId;
    @Size(max = 10, min = 10, message = "National Id should be 10 digits.")
    @NotBlank(message = "National Id is mandatory.")
    private String nationalId;
    @NotBlank(message = "First Name is mandatory.")
    private String firstName;
    @NotBlank(message = "Last Name is mandatory.")
    private String lastName;
    @Past(message = "Birth date is wrong.")
    private LocalDate birthDate;
    @NotBlank(message = "Certificate No is mandatory.")
    private String birthCertificateNo;
    @NotBlank(message = "Birth place is mandatory.")
    private String birthPlace;
    private ContactDto contactInfo;

}
