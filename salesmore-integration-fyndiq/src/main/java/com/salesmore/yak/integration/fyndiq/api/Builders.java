package com.salesmore.yak.integration.fyndiq.api;

import com.salesmore.yak.integration.fyndiq.model.articles.builder.ArticleCreateBuilder;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.ArticlePriceBuilder;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.BulkActionBuilder;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.QuantityBuilder;
import com.salesmore.yak.integration.fyndiq.model.orders.builder.OrderCreateBuilder;
import com.salesmore.yak.integration.fyndiq.service.articles.domain.ArticleConcreteCreate;
import com.salesmore.yak.integration.fyndiq.service.articles.domain.ConcreteArticlePrice;
import com.salesmore.yak.integration.fyndiq.service.articles.domain.ConcreteBulkAction;
import com.salesmore.yak.integration.fyndiq.service.articles.domain.ConcreteQuantity;
import com.salesmore.yak.integration.fyndiq.service.orders.domain.ConcreteOrderCreate;

/**
 * Utility Class to easily access all client Builders to manage model build.
 *
 */
public class Builders {

    /**
     * Get Builder to Article creation
     *
     * @return article create model builder
     */
    public static ArticleCreateBuilder article(){
        return ArticleConcreteCreate.builder();
    }

    /**
     * Get Builder to Article Price Update
     *
     * @return article price builder
     */
    public static ArticlePriceBuilder price() { return ConcreteArticlePrice.builder(); }


    /**
     * Get Builder to Article Quantity Update
     *
     * @return quantity builder
     */
    public static QuantityBuilder quantity() { return ConcreteQuantity.builder(); }

    /**
     * Get Builder to Bulk Action Update
     *
     * @return bulk action builder
     */
    public static <T> BulkActionBuilder<T> bulkAction() { return ConcreteBulkAction.builder(); }

    /**
     * Get Builder to Order Create
     *
     * @return order create builder
     */
    public static OrderCreateBuilder order() { return ConcreteOrderCreate.builder(); }

}
