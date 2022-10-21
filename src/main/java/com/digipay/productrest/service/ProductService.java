package com.digipay.productrest.service;

import com.digipay.productrest.dto.ProductDto;
import com.digipay.productrest.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    Product saveProduct(ProductDto productDto);

    List<Product> findAllProductsList();

    Optional<Product> findProductById(Long id);

    List<Product> findProductsByProductIds(Set<Long> productsId);

}
