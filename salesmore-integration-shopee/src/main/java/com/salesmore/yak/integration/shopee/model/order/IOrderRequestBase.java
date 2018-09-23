package com.salesmore.yak.integration.shopee.model.order;

import com.salesmore.yak.integration.shopee.model.IRequestBase;

public interface IOrderRequestBase extends IRequestBase {

    /**
     * Get Order Unique Identifier
     *
     * @return order sn
     */
    String getOrdersn();
}
