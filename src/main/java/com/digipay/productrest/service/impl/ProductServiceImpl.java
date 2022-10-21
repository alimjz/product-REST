package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.ProductDtoMapper;
import com.digipay.productrest.dto.ProductDto;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.exception.ErrorConstants;
import com.digipay.productrest.repository.ProductRepository;
import com.digipay.productrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository prodRepository;
    private final ProductDtoMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository prodRepository, ProductDtoMapper productMapper) {
        this.prodRepository = prodRepository;
        this.productMapper = productMapper;
    }


    @Override
    @Transactional
    public Product saveProduct(@Valid ProductDto productDto) {
        return prodRepository.save(productMapper.dtoToProductMapper(productDto));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllProductsList() {
        return prodRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Product> findProductById(Long id) {
        return prodRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Product> findProductsByProductIds(Set<Long> productsId) {
        List<Product> productList = prodRepository.findAllByProdIdIn(productsId);
        if (!productList.isEmpty() && zeroQuantsCheck(productList)) {
                return deductQuants(productList);
        }
        throw new NotFoundException(ErrorConstants.PRODUCT_NOT_FOUND);
    }


    private List<Product> deductQuants(List<Product> productList) {
        List<Product> deductedQuantsProductList = new ArrayList<>();
        for (Product product : productList) {
            product.setQuants(product.getQuants() - 1);
            deductedQuantsProductList.add(product);
        }
        return deductedQuantsProductList;
    }

    private boolean zeroQuantsCheck(List<Product> products) {
        List<Product> productZeroQuantList = new ArrayList<>();
        for (Product product : products) {
            if (product.getQuants() == 0) {
                productZeroQuantList.add(product);
            }
        }
        return productZeroQuantList.isEmpty();
    }

}
