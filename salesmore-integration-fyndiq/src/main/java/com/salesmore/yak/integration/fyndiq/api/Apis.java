package com.salesmore.yak.integration.fyndiq.api;

import com.salesmore.yak.integration.fyndiq.api.domain.ArticlesService;
import com.salesmore.yak.integration.fyndiq.api.domain.OrdersService;
import com.salesmore.yak.integration.fyndiq.api.domain.SalesFunnelsService;

import java.util.ServiceLoader;

/**
 * Provides access to the APIs and Buildables
 *
 */
public class Apis {


    private static final APIProvider provider = initializeProvider();

    /**
     * Gets the API implementation based on Type
     *
     * @param <T>
     *            the API type
     * @param api
     *            the API implementation
     * @return the API implementation
     */
    public static <T> T get(Class<T> api) {
        return provider.get(api);
    }

    /**
     *
     * @return orders service
     */
    public static OrdersService getOrdersService() {

        return get(OrdersService.class);
    }

    /**
     *
     * @return articles service
     */
    public static ArticlesService getArticlesService() {
        return get(ArticlesService.class);
    }

    /**
     *
     * @return sales funnels service
     */
    public static SalesFunnelsService getSalesFunnelsService() {
        return get(SalesFunnelsService.class);
    }

    private static APIProvider initializeProvider() {
        // No need to check for emptiness as there is default implementation registered
        APIProvider p = ServiceLoader.load(APIProvider.class, Apis.class.getClassLoader()).iterator().next();
        p.initialize();
        return p;
    }
}
