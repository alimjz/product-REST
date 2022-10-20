package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.ProductDtoMapper;
import com.digipay.productrest.dto.ProductDto;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.repository.ProductRepository;
import com.digipay.productrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository prodRepository;
    private final ProductDtoMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository prodRepository, ProductDtoMapper productMapper) {
        this.prodRepository = prodRepository;
        this.productMapper = productMapper;
    }


    @Override
    public Product saveProduct(@Valid ProductDto productDto) {
        return prodRepository.save(productMapper.dtoToProductMapper(productDto));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllProductsList() {
        return prodRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return prodRepository.findById(id);
    }

}
