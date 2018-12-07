package com.salesmore.yak.integration.fyndiq.model.orders.builder;

import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderCreate;


/**
 *
 * Builder for order create
 *
 */
public interface OrderCreateBuilder extends Buildable.Builder<OrderCreateBuilder, OrderCreate> {

    /**
     * Set Article Id
     *
     * @param articleId article id
     * @return Builder
     */
    OrderCreateBuilder articleId(String articleId);


    /**
     * Set Quantity for the order
     *
     * @param quanity quantity
     * @return Builder
     */
    OrderCreateBuilder quanitity(int quanity);
}
