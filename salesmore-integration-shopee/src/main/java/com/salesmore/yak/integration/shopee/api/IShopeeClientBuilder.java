package com.salesmore.yak.integration.shopee.api;


import com.salesmore.yak.integration.core.api.IRestClientBuilder;

public interface IShopeeClientBuilder extends IRestClientBuilder<ShopeeClient, IShopeeClientBuilder> {

    /**
     * Unique partner Id
     *
     * @param partnerId partner Id
     * @return ShopeeClient
     */
    IShopeeClientBuilder partnerId(long partnerId);

    /**
     * Assign Unique Partner Key
     *
     * @param key partner key
     * @return ShopeeClient
     */
    IShopeeClientBuilder partnerKey(String key);

    /**
     *
     * @param shopId shop id
     * @return ShopeeClient
     */
    IShopeeClientBuilder shopId(long shopId);

}
