package com.salesmore.yak.integration.fyndiq.api;

import com.salesmore.yak.integration.core.api.AbstractRestClient;
import com.salesmore.yak.integration.fyndiq.api.domain.ArticlesService;
import com.salesmore.yak.integration.fyndiq.api.domain.OrdersService;
import com.salesmore.yak.integration.fyndiq.api.domain.SalesFunnelsService;


/**
 *
 * Fyndiq Client to expose all operations
 *
 */
public interface FQClient extends AbstractRestClient<FQClient> {

    /**
     * Articles Service API
     *
     * @return articles service
     */
    ArticlesService articles();


    /**
     * Orders Service API
     *
     * @return orders service
     */
    OrdersService orders();


    /**
     * Sales-Funnels Service API
     *
     * @return sales-funnels service
     */
    SalesFunnelsService salesFunnels();
}
