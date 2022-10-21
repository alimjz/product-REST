package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.InvoiceDtoMapper;
import com.digipay.productrest.dto.InvoiceDto;
import com.digipay.productrest.entity.Invoice;
import com.digipay.productrest.entity.Product;
import com.digipay.productrest.repository.InvoiceRepository;
import com.digipay.productrest.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties(prefix = "app.sell")
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private static final Double TAX_RATE = 0.09;

    private final InvoiceDtoMapper invoiceMapper;

    private final InvoiceRepository invoiceRepository;


    @Autowired
    public InvoiceServiceImpl(InvoiceDtoMapper invoiceMapper, InvoiceRepository invoiceRepository) {
        this.invoiceMapper = invoiceMapper;
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice calculateInvoice(List<Product> products, int orderCount) {
        double totalPrice = 0;
        double totalTax = 0;
        double discountPercent = calculateDiscount(orderCount);
        for (Product product :
                products) {
            totalPrice+= product.getSellPrice();
            totalTax+= (product.getSellPrice()* TAX_RATE);
        }

        return invoiceMapper.dtoToInvoiceMapper(InvoiceDto.calculateInvoice(totalPrice,totalTax,discountPercent));

    }

    @Override
    public Invoice createInvoice(List<Product> products, int orderCount) {

        return invoiceRepository.save(calculateInvoice(products,orderCount));
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
