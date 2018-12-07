package com.salesmore.yak.integration.fyndiq.model.articles.builder;


import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.fyndiq.model.articles.*;

import java.util.List;

/**
 * Build an article for create action
 *
 */
public interface ArticleCreateBuilder extends Buildable.Builder<ArticleCreateBuilder, ArticleCreate>{

    /**
     * @see ArticleCreate#getSku()
     */
    ArticleCreateBuilder sku(String sku);

    /**
     * @see ArticleCreate#getParentSku() ()
     */
    ArticleCreateBuilder parentSku(String parentSku);

    /**
     * @see ArticleCreate#getStatus()
     */
    ArticleCreateBuilder status(Status status);

    /**
     * @see ArticleCreate#getQuantity() ()
     */
    ArticleCreateBuilder quantity(int quantity);

    /**
     * @see ArticleCreate#getTags() ()
     */
    ArticleCreateBuilder tags(List<String> tags);

    /**
     * @see ArticleCreate#getTags() ()
     */
    ArticleCreateBuilder addTag(String tag);

    /**
     * @see ArticleCreate#getSize() ()
     */
    ArticleCreateBuilder size(String size);

    /**
     * @see ArticleCreate#getBrand() ()
     */
    ArticleCreateBuilder brand(String brand);

    /**
     * @see ArticleCreate#getGtin() ()
     */
    ArticleCreateBuilder gtin(String gtin);

    /**
     * @see ArticleCreate#getColor() ()
     */
    ArticleCreateBuilder color(String color);

    /**
     * @see ArticleCreate#getMainImage() ()
     */
    ArticleCreateBuilder mainImage(String mainImage);

    /**
     * @see ArticleCreate#getImages() ()
     */
    ArticleCreateBuilder images(List<String> images);

    /**
     * Add an new image to image list to create
     *
     * @param image image url to add
     * @return builder
     */
    ArticleCreateBuilder addImage(String image);

    /**
     * @see ArticleCreate#getMarkets()
     */
    ArticleCreateBuilder markets(List<Market> markets);

    /**
     * Add a new market to create
     *
     * @param market market to add in list
     * @return builder
     */
    ArticleCreateBuilder addMarket(Market market);

    /**
     * @see ArticleCreate#getTitle()
     */
    ArticleCreateBuilder titles(List<Language> languages);

    /**
     * Add Title object with give field values
     *
     * @param language language code following  ISO-639 standard
     * @param value title content in that language
     * @return builder
     */
    ArticleCreateBuilder addTitle(String language, String value);

    /**
     * @see ArticleCreate#getDescription()
     */
    ArticleCreateBuilder descriptions(List<Language> languages);

    /**
     * Add description with properties
     *
     * @param language language code following  ISO-639 standard
     * @param value title content in that language
     * @return builder
     */
    ArticleCreateBuilder addDescription(String language, String value);


    /**
     * Add the ArticlePrice which includes price, original price and shipping price
     *
     * @param articlePrice article price object
     * @return Builder
     */
    ArticleCreateBuilder addArticlePrice(ArticlePrice articlePrice);

    /**
     * Add Price with given properties for create
     *
     * @param market market property
     * @param amount amount value
     * @param currency current code
     * @return Builder
     */
    //ArticleCreateBuilder addPrice(Market market, double amount, String currency);


    /**
     * Add Original Price with given properties for create
     *
     * @param market market property
     * @param amount amount value
     * @param currency current code
     * @return Builder
     */
    //ArticleCreateBuilder addOriginalPrice(Market market, double amount, String currency);


    /**
     * Add Shipping Price with given properties for create
     *
     * @param market market property
     * @param amount amount value
     * @param currency current code
     * @return Builder
     */
    //ArticleCreateBuilder addShippingPrice(Market market, double amount, String currency);


    /**
     * Set list of shipping time info
     *
     * @param list shipping time info list
     * @return Builder
     */
    ArticleCreateBuilder shippingTime(List<ShippingTimeInfo> list);

    /**
     * Add Shipping Time object for create
     *
     * @param market market property value
     * @param time time value
     * @return Builder
     */
    ArticleCreateBuilder addShippingTime(Market market, String time);


}
