package com.salesmore.yak.integration.shopee.api;

import com.salesmore.yak.integration.core.api.APIProvider;
import com.salesmore.yak.integration.shopee.api.domain.*;

import java.util.ServiceLoader;

/**
 * Provides access to the APIs and Buildables
 */
public class Apis {


    private static final APIProvider provider = initializeProvider();

    /**
     * Gets the API implementation based on Type
     *
     * @param <T> the API type
     * @param api the API implementation
     * @return the API implementation
     */
    public static <T> T get(Class<T> api) {
        return provider.get(api);
    }

    /**
     * @return orders service
     */
    public static ShopService getShopService() {

        return get(ShopService.class);
    }

    /**
     * @return shop category service
     */
    public static ShopCategoryService shopCategoryService() {
        return get(ShopCategoryService.class);
    }

    /**
     * Get Item Service
     *
     * @return item service
     */
    public static ItemService itemService() {
        return get(ItemService.class);
    }

    /**
     * Get Image Service
     *
     * @return image service
     */
    public static ImageService imageService() {
        return get(ImageService.class);
    }

    /**
     * Get Discount Service
     *
     * @return discount service
     */
    public static DiscountService discountService() {
        return get(DiscountService.class);
    }

    /**
     * Get Order Service
     *
     * @return Order service
     */
    public static OrderService orderService() {
        return get(OrderService.class);
    }

    /**
     * Get Logistics Service
     *
     * @return Logistics service
     */
    public static LogisticsService logisticsService() {
        return get(LogisticsService.class);
    }

    /**
     * Get Returns Service
     *
     * @return Returns service
     */
    public static ReturnsService returnsService() {
        return get(ReturnsService.class);
    }

    /**
     * Initialize API Provider
     *
     * @return api providers in path
     */
    private static APIProvider initializeProvider() {
        // No need to check for emptiness as there is default implementation registered
        APIProvider p = ServiceLoader.load(APIProvider.class, Apis.class.getClassLoader()).iterator().next();
        p.initialize();
        return p;
    }
}
