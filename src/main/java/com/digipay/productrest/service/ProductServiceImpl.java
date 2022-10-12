package com.digipay.productrest.service;

import com.digipay.productrest.entity.Product;
import com.digipay.productrest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private  ProductRepository prodRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository prodRepository) {
        this.prodRepository = prodRepository;
    }


    @Override
    public Product saveProduct(@Valid Product product) {
        Optional<Product> existProd = prodRepository.findByProdCode(product.getProdCode());
        if (existProd.isPresent()) {
            return existProd.get();
        }
        else {
            return prodRepository.save(product);
        }
    }

    @Override
    public List<Product> findAllProductsList() {
        return prodRepository.findAll();
    }
}
