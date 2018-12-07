package com.salesmore.yak.integration.fyndiq.model.articles;

import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.ArticlePriceBuilder;

import java.util.List;

/**
 * Model Used for Price Update
 *
 */
public interface ArticlePrice extends ModelEntity, Buildable<ArticlePriceBuilder> {

    /**
     * Get Price
     *
     * @return actual price
     */
    List<? extends PriceInfo> getPrice();

    /**
     * Get Original Price
     *
     * @return original price
     */
    List<? extends PriceInfo> getOriginalPrice();

    /**
     * Get Shipping Price
     *
     * @return list of possible shipping price
     */
    List<? extends PriceInfo> getShippingPrice();
}
