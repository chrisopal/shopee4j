package com.salesmore.yak.integration.fyndiq.service.articles.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.salesmore.yak.integration.fyndiq.model.articles.Market;
import com.salesmore.yak.integration.fyndiq.model.articles.PriceInfo;
import com.salesmore.yak.integration.fyndiq.model.articles.PriceValue;


public class PriceInfoInternal implements PriceInfo {

    private static final long serialVersionUID = 1L;

    public PriceInfoInternal() {}

    public PriceInfoInternal(Market market, double amount, String currency){
        this.market = market;
        this.value = new PriceValue(amount, currency);
    }

    private Market market;
    @JsonProperty("value")
    private PriceValue value;

    @Override
    public Market getMarket() {
        return market;
    }

    @Override
    public PriceValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("market", getMarket().value())
                .add("value", value)
                .toString();
    }
}
