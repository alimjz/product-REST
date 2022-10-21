package com.digipay.productrest.service;

import com.digipay.productrest.entity.Invoice;
import com.digipay.productrest.entity.Product;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    Invoice createInvoice(List<Product> products, int orderCount);
    Optional<Invoice> queryInvoice(String id);


}
