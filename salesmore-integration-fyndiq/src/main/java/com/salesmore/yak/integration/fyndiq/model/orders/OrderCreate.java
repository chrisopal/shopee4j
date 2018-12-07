package com.salesmore.yak.integration.fyndiq.model.orders;

import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.fyndiq.model.orders.builder.OrderCreateBuilder;

/**
 * Model for Order Creation
 */
public interface OrderCreate extends ModelEntity, Buildable<OrderCreateBuilder> {

    /**
     * Get Article Id of the order
     *
     * @return article id
     */
    String getArticleId();

    /**
     * Get Quantity of the order
     *
     * @return quantity
     */
    int getQuantity();
}
