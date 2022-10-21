package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.InvoiceDtoMapper;
import com.digipay.productrest.dto.InvoiceDto;
import com.digipay.productrest.entity.Invoice;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties(prefix = "app.sell")
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {
    private static final Double TAX_RATE = 0.09;

    private final InvoiceDtoMapper invoiceMapper;



    @Autowired
    public InvoiceServiceImpl(InvoiceDtoMapper invoiceMapper) {
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public Invoice calculateInvoice(List<Product> products, int orderCount) {
        double totalPrice = 0;
        double totalTax = 0;
        double discountPercent = calculateDiscount(orderCount);
        for (Product product :
                products) {
            totalPrice+= product.getSellPrice();
            totalTax+= (product.getSellPrice()* TAX_RATE);
        }

        InvoiceDto invoiceDto=new InvoiceDto();
        invoiceDto.setBaseFee(totalPrice);
        invoiceDto.setTax( totalTax);
        invoiceDto.setDiscountPercent(discountPercent);
        invoiceDto.setDiscountAmount((totalPrice + totalTax) * discountPercent);
        invoiceDto.setPayAbleAmount(totalPrice+totalTax- invoiceDto.getDiscountAmount());
        log.info(invoiceDto.toString());
        return invoiceMapper.dtoToInvoiceMapper(invoiceDto);

    }

    @Override
    public Invoice createInvoice(List<Product> products, int orderCount) {
        return calculateInvoice(products,orderCount);
    }

    @Override
    public Optional<Invoice> queryInvoice(String id) {
        return Optional.empty();
    }

    private Double calculateDiscount(int orderCount){
        if (orderCount <= 5)
            return 0D;
        else if(orderCount> 6 && orderCount < 11)
            return 0.03D;
        else
            return 0.05D;
    }


}
