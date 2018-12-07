package com.salesmore.yak.integration.fyndiq.model.articles.builder;

import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.fyndiq.model.articles.Quantity;

public interface QuantityBuilder extends Buildable.Builder<QuantityBuilder, Quantity> {

    /**
     * Set Quantity
     *
     * @param quantity of the article
     * @return Builder
     */
    QuantityBuilder quantity(int quantity);
}
