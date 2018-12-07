package com.salesmore.yak.integration.fyndiq.model.articles;

import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.QuantityBuilder;

public interface Quantity extends ModelEntity, Buildable<QuantityBuilder> {

    /**
     *
     * Article Quantity to Update
     *
     * @return quantity
     */
    int getQuantity();
}
