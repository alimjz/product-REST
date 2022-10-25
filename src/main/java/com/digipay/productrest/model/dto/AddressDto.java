package com.digipay.productrest.model.dto;

import com.digipay.productrest.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Size;

public class AddressDto {
    @JsonIgnore
    private String addressId;
    private AddressType addressType;
    private String province;
    private String city;
    private String street;

    private String buildingNo;
    @Size(min = 10, max = 10, message = "Postal code is not correct.")
    private String postalCode;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
