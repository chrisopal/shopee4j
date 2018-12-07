package com.salesmore.yak.integration.fyndiq.model.articles;


import com.google.common.base.MoreObjects;
import com.salesmore.yak.integration.core.model.ModelEntity;

/**
 *
 * Shipping time info
 */
public class ShippingTimeInfo implements ModelEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private Market market;
    private String value;

    public ShippingTimeInfo() {
    }

    public ShippingTimeInfo(Market market, String value) {
        this.market = market;
        this.value = value;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("market", getMarket().value())
                .add("value", value)
                .toString();
    }
}
