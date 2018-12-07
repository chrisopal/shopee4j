package com.salesmore.yak.integration.fyndiq.model.articles;

import com.google.common.base.MoreObjects;
import com.salesmore.yak.integration.core.model.ModelEntity;

import java.util.Currency;

/**
 *
 * Price Value Object
 */
public class PriceValue implements ModelEntity {

    private double amount;
    //mapping to java.util.Currency
    private String currency;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    public PriceValue() {}

    public PriceValue(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public PriceValue(double amount, Currency cur) {
        this.amount = amount;
        this.currency = cur.getCurrencyCode();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCurrency(Currency currency){
        this.currency = currency.getCurrencyCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("amount", amount)
                .add("currency", currency)
                .toString();
    }
}
