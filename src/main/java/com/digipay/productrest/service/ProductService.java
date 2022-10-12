package com.digipay.productrest.service;

import com.digipay.productrest.dto.ProductDto;
import com.digipay.productrest.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductDto productDto);

    List<Product> findAllProductsList();
}
