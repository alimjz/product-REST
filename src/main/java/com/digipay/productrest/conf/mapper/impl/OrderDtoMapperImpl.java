package com.digipay.productrest.conf.mapper.impl;

import com.digipay.productrest.conf.mapper.OrderDtoMapper;
import com.digipay.productrest.dto.OrderDto;
import com.digipay.productrest.entity.Order;
import com.digipay.productrest.entity.Product;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-20T20:29:58+0330",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_341 (Oracle Corporation)"
)
@Component
public class OrderDtoMapperImpl implements OrderDtoMapper {

    @Override
    public Order dtoToOrderMapper(OrderDto order) {
        if ( order == null ) {
            return null;
        }

        Order order1 = new Order();

        order1.setOrderId( order.getOrderId() );
        List<Product> list = order.getProduct();
        if ( list != null ) {
            order1.setProduct( new ArrayList<Product>( list ) );
        }
        order1.setStatus( order.getStatus() );
        order1.setBusinessCode( order.getBusinessCode() );
        order1.setStatusDate( order.getStatusDate() );
        order1.setInvoice( order.getInvoice() );
        order1.setCustomer( order.getCustomer() );


        return order1;
    }

    @Override
    public OrderDto orderToDtoMapper(Order orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        OrderDto orderDto1 = new OrderDto();

        orderDto1.setOrderId( orderDto.getOrderId() );
        List<Product> list = orderDto.getProduct();
        if ( list != null ) {
            orderDto1.setProduct( new ArrayList<Product>( list ) );
        }
        orderDto1.setCreateDate( orderDto.getCreateDate() );
        orderDto1.setStatus( orderDto.getStatus() );
        orderDto1.setBusinessCode( orderDto.getBusinessCode() );
        orderDto1.setStatusDate( orderDto.getStatusDate() );
        orderDto1.setInvoice( orderDto.getInvoice() );
        orderDto1.setCustomer( orderDto.getCustomer() );


        return orderDto1;
    }
}
