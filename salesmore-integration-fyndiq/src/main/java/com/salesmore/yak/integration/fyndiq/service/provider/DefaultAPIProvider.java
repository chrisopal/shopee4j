package com.salesmore.yak.integration.fyndiq.service.provider;

import com.google.common.collect.Maps;
import com.salesmore.yak.integration.core.api.exceptions.ApiNotFoundException;
import com.salesmore.yak.integration.fyndiq.api.APIProvider;
import com.salesmore.yak.integration.fyndiq.api.domain.ArticlesService;
import com.salesmore.yak.integration.fyndiq.api.domain.OrdersService;
import com.salesmore.yak.integration.fyndiq.api.domain.SalesFunnelsService;
import com.salesmore.yak.integration.fyndiq.service.articles.ArticlesServiceImpl;
import com.salesmore.yak.integration.fyndiq.service.orders.OrdersServiceImpl;
import com.salesmore.yak.integration.fyndiq.service.salesfunnes.SalesFunnelsServiceImpl;

import java.util.Map;


/**
 *
 * Simple API Provider which keeps internally Maps interface implementations as singletons
 *
 */
public class DefaultAPIProvider implements APIProvider {

    private static final Map<Class<?>, Class<?>> bindings = Maps.newHashMap();
    private static final Map<Class<?>, Object> instances = Maps.newConcurrentMap();

    @Override
    public void initialize() {
        bind(ArticlesService.class, ArticlesServiceImpl.class);
        bind(OrdersService.class, OrdersServiceImpl.class);
        bind(SalesFunnelsService.class, SalesFunnelsServiceImpl.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Class<T> api) {
        if (instances.containsKey(api))
            return (T) instances.get(api);

        if (bindings.containsKey(api)) {
            try {
                T impl = (T) bindings.get(api).newInstance();
                instances.put(api, impl);
                return impl;
            } catch (Exception e) {
                throw new ApiNotFoundException("API Not found for: " + api.getName(), e);
            }
        }
        throw new ApiNotFoundException("API Not found for: " + api.getName());
    }

    private void bind(Class<?> api, Class<?> impl) {
        bindings.put(api, impl);
    }
}
