package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.dto.OrderDto;
import com.digipay.productrest.entity.Customer;
import com.digipay.productrest.entity.Invoice;
import com.digipay.productrest.entity.Order;
import com.digipay.productrest.entity.Product;

import java.util.List;
import java.util.Optional;

//@Mapper(componentModel = "spring")
public interface OrderDtoMapper {
    Order dtoToOrderMapper(OrderDto order, List<Product> products, Optional<Customer> customer, Invoice invoice) ;
    OrderDto orderToDtoMapper(Order orderDto);
}
