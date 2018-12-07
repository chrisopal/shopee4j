package com.salesmore.yak.integration.fyndiq.model.articles.builder;

import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.fyndiq.model.articles.ArticlePrice;
import com.salesmore.yak.integration.fyndiq.model.articles.Market;

public interface ArticlePriceBuilder extends Buildable.Builder<ArticlePriceBuilder, ArticlePrice> {

    /**
     * Add Price with given properties for create
     *
     * @param market market property
     * @param amount amount value
     * @param currency current code
     * @return Builder
     */
    ArticlePriceBuilder addPrice(Market market, double amount, String currency);


    /**
     * Add Original Price with given properties for create
     *
     * @param market market property
     * @param amount amount value
     * @param currency current code
     * @return Builder
     */
    ArticlePriceBuilder addOriginalPrice(Market market, double amount, String currency);


    /**
     * Add Shipping Price with given properties for create
     *
     * @param market market property
     * @param amount amount value
     * @param currency current code
     * @return Builder
     */
    ArticlePriceBuilder addShippingPrice(Market market, double amount, String currency);
}
