package com.salesmore.yak.integration.fyndiq.model.orders;

import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.fyndiq.model.articles.Market;
import com.salesmore.yak.integration.fyndiq.model.articles.PriceValue;

/**
 *
 * Order Info
 *
 */
public interface Order extends ModelEntity {

    /**
     * Get Order Id
     *
     * @return order id
     */
    String getId();

    /**
     * Get Article Id
     *
     * @return article id
     */
    String getArticleId();

    /**
     * Get Article Title
     *
     * @return article title
     */
    String getArticleTitle();

    /**
     * Get Article Sku
     *
     * @return Article Sku
     */
    String getArticleSku();

    /**
     * Get Article Price
     *
     * @return article price
     */
    PriceValue getArticlePrice();

    /**
     * Get Vat Rate
     *
     * @return Vat Rate
     */
    String getArticleVatRate();

    /**
     * Get Shipping Price
     *
     * @return Shipping Price
     */
    PriceValue getShippingPrice();

    /**
     * Get Shipping Vat Rate
     *
     * @return shipping vat rate
     */
    String getShippingVatRate();

    /**
     * Get Quantity
     *
     * @return Quantity
     */
    int getQuantity();

    /**
     * Get Total Price
     *
     * @return Total price
     */
    PriceValue getTotalPrice();

    /**
     * Get Shipping Address
     *
     * @return shipping address
     */
    ShippingAddress getShippingAddress();

    /**
     * Get Market
     *
     * @return market
     */
    Market getMarket();

    /**
     * Get State
     *
     * @return state
     */
    State getState();

    /**
     * Get Create At
     *
     * @return created at
     */
    String getCreatedAt();

    /**
     * Get Fulfill Before
     *
     * @return fulfill before
     */
    String fulfillBefore();

}
