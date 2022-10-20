package com.digipay.productrest.service;

import com.digipay.productrest.entity.Invoice;
import com.digipay.productrest.entity.Order;

import java.util.Optional;

public interface InvoiceService {

    Invoice saveInvoice(Order order);
    Optional<Invoice> queryInvoice(String id);

    Double calculateDiscount();
}
