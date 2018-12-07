package com.salesmore.yak.integration.fyndiq.model.salesfunnels;

import com.salesmore.yak.integration.core.model.ModelEntity;


/**
 *
 * Funnel Data
 *
 */
public interface FunnelData extends ModelEntity {

    /**
     * Get Date
     *
     * @return date
     */
    String getDate();

    /**
     * Get Product Viewed
     *
     * @return product viewed
     */
    int getProductViewed();

    /**
     * Get Article Added
     *
     * @return article added
     */
    int getArticleAdded();

    /**
     * Get Checkout Started
     *
     * @return checkout started
     */
    int getCheckoutStarted();

    /**
     * Get Quantity Sold
     *
     * @return quantity sold
     */
    int getQuantitySold();
}
