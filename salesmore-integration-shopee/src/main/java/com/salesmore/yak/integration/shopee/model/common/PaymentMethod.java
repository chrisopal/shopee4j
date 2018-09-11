package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum  PaymentMethod {


    PAY_NONE("Free order payment method"),
    PAY_CYBERSOURCE("Cybersource credit payment method"),
    PAY_BANK_TRANSFER("Bank transfer payment method"),
    PAY_OFFLINE_PAYMENT("Offline payment method"),
    PAY_IPAY88("MY payment method"),
    PAY_FREE("Free payment method"),
    PAY_COD("Cash on delivery payment method"),
    PAY_ESUN("TW used payment method"),
    PAY_BILL_PAYMENT("TH bill payment method"),
    PAY_INDOMARET("Indomaret payment method"),
    PAY_KREDIVO("Kredivo payment method"),
    PAY_NICEPAY_CC("Nicepay Credit Card payment method"),
    PAY_ESUN_CB("Esun Cross Border payment method"),
    PAY_IPAY88_CC("IPay88 Credit Card payment method"),
    PAY_AIRPAY_CC("Airpay Credit Card payment method"),
    PAY_BCA_ONE_KLIK("BCA One Click payment method"),
    PAY_SHOPEE_WALLET("Shopee wallet payment method"),
    PAY_AKULAKU("Akulaku payment method"),
    PAY_STRIPE_CC("Stripe Credit Card payment method"),
    PAY_AIRPAY_CC_INSTALLMENT("Airpay Credit Card Installment payment method");

    private String description;

    PaymentMethod(String des){
        this.description = des;
    }

    public String getDescription(){
        return this.description;
    }

    @JsonCreator
    public static PaymentMethod value(String v) {
        if (v == null) return PAY_NONE;
        try {
            return valueOf(v);
        } catch (IllegalArgumentException e) {
            return PAY_NONE;
        }
    }

    @JsonValue
    public String value() {
        return name();
    }
}
