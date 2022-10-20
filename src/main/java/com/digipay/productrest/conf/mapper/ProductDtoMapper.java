package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.dto.ProductDto;
import com.digipay.productrest.entity.Product;

//@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    Product dtoToProductMapper(ProductDto productDto);
    ProductDto productToDtoMapper(Product productDto);
}
