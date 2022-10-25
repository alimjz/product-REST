package com.digipay.productrest.service;

import com.digipay.productrest.model.dto.ProductDto;
import com.digipay.productrest.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    Product stockInProducts(ProductDto productDto);

    Page<Product> findAllProductsList(Pageable pageable);

    Optional<Product> findProductById(Long id);

    List<Product> findNonZeroQuantsProducts(Set<Long> productsId);

}
