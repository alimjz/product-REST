package com.digipay.productrest.repository;

import com.digipay.productrest.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,String> {
}
