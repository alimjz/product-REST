package com.digipay.productrest.service.impl;

import com.digipay.productrest.conf.mapper.InvoiceDtoMapper;
import com.digipay.productrest.dto.InvoiceDto;
import com.digipay.productrest.entity.Invoice;
import com.digipay.productrest.entity.Order;
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

    public InvoiceDto calculateInvoice(Order order) {
        List<Product> productList = order.getProduct();
        double totalPrice = 0;
        double totalTax = 0;
        for (Product product :
                productList) {
            totalPrice+= product.getSellPrice();
            totalTax+= (product.getSellPrice()* TAX_RATE);
        }
        InvoiceDto invoice = new InvoiceDto();
        invoice.setTax(totalTax);
        invoice.setBaseFee(totalPrice);
        invoice.setPayAbleAmount(totalPrice+totalTax);
        invoice.setDiscountPercent(0D);
        invoice.setDiscountPercent(0D);
        return invoice;
    }

    @Override
    public Invoice saveInvoice(Order order) {
        return invoiceRepository.save(invoiceMapper.dtoToInvoiceMapper(calculateInvoice(order)));
    }

    @Override
    public Optional<Invoice> queryInvoice(String id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Double calculateDiscount() {
        return 0.1D;
    }
}
