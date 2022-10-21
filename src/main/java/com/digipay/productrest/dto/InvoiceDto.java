package com.digipay.productrest.dto;

import com.digipay.productrest.entity.Invoice;

public class InvoiceDto {

    private String invoiceId;
    private Double baseFee;
    private Double tax;
    private Double discountPercent;
    private Double discountAmount;
    private Double payAbleAmount;

    public static InvoiceDto calculateInvoice(double totalPrice, double totalTax, double discountPercent){
        InvoiceDto invoiceDto=new InvoiceDto();
        invoiceDto.setBaseFee(totalPrice);
        invoiceDto.setTax( totalTax);
        invoiceDto.setDiscountPercent(discountPercent);
        invoiceDto.setDiscountAmount((totalPrice + totalTax) * discountPercent);
        invoiceDto.setPayAbleAmount(totalPrice+totalTax- invoiceDto.getDiscountAmount());
        return invoiceDto;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(Double baseFee) {
        this.baseFee = baseFee;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getPayAbleAmount() {
        return payAbleAmount;
    }

    public void setPayAbleAmount(Double payAbleAmount) {
        this.payAbleAmount = payAbleAmount;
    }
}
