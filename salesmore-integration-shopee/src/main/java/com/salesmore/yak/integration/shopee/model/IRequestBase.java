package com.salesmore.yak.integration.shopee.model;


import com.salesmore.yak.integration.core.model.ModelEntity;

/**
 * Request Body base fields that must be included by all requests
 */

public interface IRequestBase extends ModelEntity {

    /**
     * Get Partner id
     *
     * @return partner id
     */
    long getPartnerId();

    /**
     * Get shop id
     * @return shop id
     */
    long getShopId();

    /**
     * Get Timestamp
     * @return timestamp
     */
    long getTimestamp();
}
