package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.dto.OrderDto;
import com.digipay.productrest.entity.Order;

//@Mapper(componentModel = "spring")
public interface OrderDtoMapper {
    Order dtoToOrderMapper(OrderDto order);
    OrderDto orderToDtoMapper(Order orderDto);
}
