package com.salesmore.yak.integration.fyndiq.model.articles;


import com.salesmore.yak.integration.core.model.ModelEntity;

/**
 *
 * Price Object
 *
 */
public interface PriceInfo extends ModelEntity {

    /**
     *
     * @return market of the price
     */
    Market getMarket();


    /**
     *
     * @return price value
     */
    PriceValue getValue();

}
