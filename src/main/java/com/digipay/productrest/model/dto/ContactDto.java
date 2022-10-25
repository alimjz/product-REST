package com.digipay.productrest.model.dto;

import com.digipay.productrest.model.entity.Address;
import com.digipay.productrest.model.entity.ContactType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Email;

public class ContactDto {
    @JsonIgnore
    private String contactId;
    private ContactType contactType;
    private String phoneNumber;
    @Email(message = "The Email format is not correct.")
    private String email;
    private Address address;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
