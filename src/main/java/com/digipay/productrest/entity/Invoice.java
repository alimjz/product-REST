package com.digipay.productrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_INVOICE")
public class Invoice {
    @Id
    @Column(name = "INVOICE_ID")
    private String invoiceId;
    private long baseFee;
    private long tax;
    private long discountPercent;
    private long discountAmount;
    private long payAbleAmount;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public long getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(long baseFee) {
        this.baseFee = baseFee;
    }

    public long getTax() {
        return tax;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }

    public long getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(long discountPercent) {
        this.discountPercent = discountPercent;
    }

    public long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public long getPayAbleAmount() {
        return payAbleAmount;
    }

    public void setPayAbleAmount(long payAbleAmount) {
        this.payAbleAmount = payAbleAmount;
    }
}
