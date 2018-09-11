package com.salesmore.yak.integration.shopee.api;

import com.salesmore.yak.integration.core.api.APIProvider;
import com.salesmore.yak.integration.shopee.api.domain.ShopService;

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
    public static ShopService getShopService() {

        return get(ShopService.class);
    }


    private static APIProvider initializeProvider() {
        // No need to check for emptiness as there is default implementation registered
        APIProvider p = ServiceLoader.load(APIProvider.class, Apis.class.getClassLoader()).iterator().next();
        p.initialize();
        return p;
    }
}
