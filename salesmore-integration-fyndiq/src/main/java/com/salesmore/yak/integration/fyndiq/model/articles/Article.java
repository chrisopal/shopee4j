package com.salesmore.yak.integration.fyndiq.model.articles;

import com.salesmore.yak.integration.core.model.ModelEntity;

import java.util.List;

/**
 * Article Model
 *
 */
public interface Article extends ModelEntity {

    /**
     * Get Article Id
     *
     * @return id
     */
    String getId();

    /**
     * Get Product Id
     *
     * @return product Id
     */
    String getProductId();

    /**
     * Get Merchant Id
     *
     * @return merchant id
     */
    String getMerchantId();

    /**
     * Get Fyndiq Status
     *
     * @return fyndiq status
     */
    String getFyndiqStatus();

    /**
     * Get Fyndiq Reasons
     *
     * @return fyndiq reasons
     */
    List<String> getFyndiqReasons();

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
     * Get Properties
     *
     * @return properties
     */
    List<PropertyPair> getProperties();

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
