package com.digipay.productrest.service;

import com.digipay.productrest.dto.ProductDto;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

// TODO: 10/16/2022 why since there is no transaction, it is working. 
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository prodRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository prodRepository) {
        this.prodRepository = prodRepository;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Product saveProduct(@Valid ProductDto productDto) {
        Product productEntity = getProductEntity(productDto);
        return prodRepository.save(productEntity);
    }

    @Override
    @Transactional(readOnly = true)
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
