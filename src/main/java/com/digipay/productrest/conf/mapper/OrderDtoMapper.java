package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.model.dto.OrderDto;
import com.digipay.productrest.model.entity.Customer;
import com.digipay.productrest.model.entity.Invoice;
import com.digipay.productrest.model.entity.Order;
import com.digipay.productrest.model.entity.Product;

import java.util.List;
import java.util.Optional;

//@Mapper(componentModel = "spring")
public interface OrderDtoMapper {
    Order convertDtoToOrder(OrderDto order, List<Product> products, Optional<Customer> customer, Invoice invoice);

}
