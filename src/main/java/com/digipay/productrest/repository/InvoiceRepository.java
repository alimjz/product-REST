package com.digipay.productrest.repository;

import com.digipay.productrest.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {
}
