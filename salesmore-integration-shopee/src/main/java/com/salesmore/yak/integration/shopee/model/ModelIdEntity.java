package com.salesmore.yak.integration.shopee.model;

import com.salesmore.yak.integration.core.model.ModelEntity;

/**
 * Interface for Model Entity with Id and Msg properties like delete response
 */
public interface ModelIdEntity extends ModelEntity {

    /**
     * Get Id
     *
     * @return id
     */
    Long getId();

    /**
     * Get Operation Message
     *
     * @return operation message
     */
    String getMsg();
}
