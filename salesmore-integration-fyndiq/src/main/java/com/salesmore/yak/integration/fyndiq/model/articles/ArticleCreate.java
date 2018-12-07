package com.salesmore.yak.integration.fyndiq.model.articles;


import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.ArticleCreateBuilder;

import java.util.List;

/**
 * Article model for get/create
 *
 */
public interface ArticleCreate extends ModelEntity, Buildable<ArticleCreateBuilder> {

    /**
     * Get unique id for the article
     *
     * @return sku
     */
    String getSku();

    /**
     * Get Group-identifier for the product
     *
     * @return parent sku
     */
    String getParentSku();

    /**
     * Get Status
     *
     * @return status
     */
    Status getStatus();

    /**
     * Get Quantity
     *
     * @return Quantity
     */
    int getQuantity();

    /**
     * Get Tags
     *
     * @return tags
     */
    List<String> getTags();

    /**
     * Get Size
     *
     * @return size
     */
    String getSize();

    /**
     * Get Color
     *
     * @return color
     */
    String getColor();

    /**
     * Get Brand
     *
     * @return brand
     */
    String getBrand();

    /**
     * Get gtin
     *
     * @return gtin
     */
    String getGtin();

    /**
     * Get Main Image
     *
     * @return Main Image
     */
    String getMainImage();

    /**
     * Get Images
     *
     * @return images
     */
    List<String> getImages();


    /**
     * Get Markets
     *
     * @return markets
     */
    List<Market> getMarkets();

    /**
     * Get Title
     *
     * @return Title
     */
    List<Language> getTitle();

    /**
     * Get Description
     *
     * @return description
     */
    List<Language> getDescription();

    /**
     * Get Price
     *
     * @return actual price
     */
    List<? extends PriceInfo> getPrice();

    /**
     * Get Original Price
     *
     * @return original price
     */
    List<? extends PriceInfo> getOriginalPrice();

    /**
     * Get Shipping Price
     *
     * @return list of possible shipping price
     */
    List<? extends PriceInfo> getShippingPrice();

    /**
     * Get Shipping Time
     *
     * @return list of possible shipping time
     */
    List<? extends ShippingTimeInfo> getShippingTime();


}
