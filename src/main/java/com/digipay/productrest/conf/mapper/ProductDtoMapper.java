package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.model.dto.ProductDto;
import com.digipay.productrest.model.entity.Product;

//@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    Product dtoToProductMapper(ProductDto productDto);

    ProductDto productToDtoMapper(Product productDto);
}
