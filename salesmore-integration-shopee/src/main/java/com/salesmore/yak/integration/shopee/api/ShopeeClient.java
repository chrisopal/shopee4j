package com.salesmore.yak.integration.shopee.api;

import com.salesmore.yak.integration.core.api.AbstractRestClient;
import com.salesmore.yak.integration.shopee.api.domain.ShopService;


/**
 *
 * Shopee Client to expose all operations
 *
 */
public interface ShopeeClient extends AbstractRestClient<ShopeeClient> {

    /**
     * Shops Service API
     *
     * @return Shop service
     */
    ShopService shops();
}
