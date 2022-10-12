package com.digipay.productrest.service;

import com.digipay.productrest.dto.ProductDto;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository prodRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository prodRepository) {
        this.prodRepository = prodRepository;
    }


    @Override
    public Product saveProduct(@Valid ProductDto productDto) {
        Product productEntity = getProductEntity(productDto);
        return prodRepository.save(productEntity);
    }

    @Override
    public List<Product> findAllProductsList() {
        return prodRepository.findAll();
    }

    private Product getProductEntity(ProductDto productDto) {

        Product object = new Product();
        object.setProdName(productDto.getProdName());
        object.setProdCode(productDto.getProdCode());
        object.setModel(productDto.getModel());
        object.setBuyPrice(productDto.getBuyPrice());
        object.setProdSubType(productDto.getProdSubType());
        object.setProdType(productDto.getProdType());
        object.setSellPrice(productDto.getSellPrice());
        object.setBuyPrice(productDto.getBuyPrice());
        return object;
    }
}
