package com.digipay.productrest.service;

import com.digipay.productrest.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> findAllProductsList();
}
