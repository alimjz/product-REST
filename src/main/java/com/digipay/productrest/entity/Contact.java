package com.digipay.productrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CONTACT")
public class Contact {
    @Id
    @Column(name = "CONTACT_ID")
    private String contactId;
    private ContactType contactType;
    private String phoneNumber;
    private String email;
    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
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
