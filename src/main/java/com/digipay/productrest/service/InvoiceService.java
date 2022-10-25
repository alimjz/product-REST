package com.digipay.productrest.service;

import com.digipay.productrest.model.entity.Invoice;
import com.digipay.productrest.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    Invoice calculateInvoiceForSales(List<Product> products, String customerId);

    Optional<Invoice> queryInvoice(String id);

    Invoice calculateInvoice(List<Product> products, String customerId);


}
