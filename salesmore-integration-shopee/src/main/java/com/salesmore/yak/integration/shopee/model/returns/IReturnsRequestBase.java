package com.salesmore.yak.integration.shopee.model.returns;

import com.salesmore.yak.integration.shopee.model.IRequestBase;

public interface IReturnsRequestBase extends IRequestBase {

    /**
     * Get Order Unique Identifier
     *
     * @return order sn
     */
    String getReturnsn();
}
