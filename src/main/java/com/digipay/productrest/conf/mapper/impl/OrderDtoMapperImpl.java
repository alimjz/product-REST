package com.digipay.productrest.conf.mapper.impl;

import com.digipay.productrest.conf.mapper.OrderDtoMapper;
import com.digipay.productrest.dto.OrderDto;
import com.digipay.productrest.entity.*;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-20T20:29:58+0330",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_341 (Oracle Corporation)"
)
@Component
public class OrderDtoMapperImpl implements OrderDtoMapper {

    @Override
    public Order dtoToOrderMapper(OrderDto order, List<Product> products, Optional<Customer> customer,
                                  Invoice invoice) {
        if ( order == null ) {
            return null;
        }
        Order orderObj = new Order();
        SalesItem salesItem = new SalesItem();
        salesItem.setProducts(products);
        orderObj.setCustomer(customer.get());
        orderObj.setSalesItem(salesItem);
        orderObj.setInvoice(invoice);
        return orderObj;
    }

    @Override
    public OrderDto orderToDtoMapper(Order orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        OrderDto orderDto1 = new OrderDto();

        orderDto1.setOrderId( orderDto.getOrderId() );
//        List<Product> list = orderDto.getProduct();
//        if ( list != null ) {
//            orderDto1.setProduct( new ArrayList<Product>( list ) );
//        }
/*
        orderDto1.setCreateDate( orderDto.getCreateDate() );
        orderDto1.setStatus( orderDto.getStatus() );
        orderDto1.setBusinessCode( orderDto.getBusinessCode() );
        orderDto1.setStatusDate( orderDto.getStatusDate() );
        orderDto1.setInvoice( orderDto.getInvoice() );
        orderDto1.setCustomer( orderDto.getCustomer() );
*/


        return orderDto1;
    }
}
