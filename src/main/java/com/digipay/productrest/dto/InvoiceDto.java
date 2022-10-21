package com.digipay.productrest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

@ToString
public class InvoiceDto {
    @JsonIgnore
    private String invoiceId;
    private Double baseFee;
    private Double tax;
    private Double discountPercent;
    private Double discountAmount;
    private Double payAbleAmount;


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
