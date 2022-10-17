package com.digipay.productrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USER")
public class User {
    @Id
    @Column(name = "USER_ID")
    private String userId;
    private String userName;
    private String userLastName;
    private Role role;
    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contact;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
