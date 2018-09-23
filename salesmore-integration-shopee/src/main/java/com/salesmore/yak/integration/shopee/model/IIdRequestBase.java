package com.salesmore.yak.integration.shopee.model;

/**
 * Base Request that has Id field for all Model Entity, like shop, category, item etc.
 */
public interface IIdRequestBase extends IRequestBase{

    /**
     * Unique Identifier for each Model
     *
     * @return id
     */
    Long getId();
}
