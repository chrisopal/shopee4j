package com.salesmore.yak.integration.shopee.service.provider;

import com.google.common.collect.Maps;
import com.salesmore.yak.integration.core.api.APIProvider;
import com.salesmore.yak.integration.core.api.exceptions.ApiNotFoundException;
import com.salesmore.yak.integration.shopee.api.domain.ShopService;
import com.salesmore.yak.integration.shopee.service.shop.ShopServiceImpl;


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
        bind(ShopService.class, ShopServiceImpl.class);
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
