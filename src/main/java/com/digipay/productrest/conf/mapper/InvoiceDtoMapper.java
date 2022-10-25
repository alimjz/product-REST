package com.digipay.productrest.conf.mapper;

import com.digipay.productrest.model.dto.InvoiceDto;
import com.digipay.productrest.model.entity.Invoice;

//@Mapper(componentModel = "spring")
public interface InvoiceDtoMapper {
    Invoice dtoToInvoiceMapper(InvoiceDto invoiceDto);

    InvoiceDto invoiceToDtoMapper(Invoice invoice);
}
