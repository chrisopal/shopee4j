package com.salesmore.yak.integration.shopee.api;

import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopAuth;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopInfoUpdate;

/**
 * Utility Class to easily access all client Builders to manage model build.
 *
 */
public class Builders {

    /**
     * Get Builder to ShopInfo Request
     *
     * @return base request builder
     */
    public static BaseRequest.BaseRequestBuilder baseRequest() { return BaseRequest.builder(); }


    /**
     * Get Builder to ShopInfo Update creation
     *
     * @return shop info update builder
     */
    public static ShopInfoUpdate.ShopInfoUpdateBuilder shopInfoUpdate() { return ShopInfoUpdate.builder(); }

    /**
     * Get Builder to Shop Authorization creation
     *
     * @return shop auth builder builder
     */
    public static ShopAuth.ShopAuthBuilder shopAuth() { return ShopAuth.builder(); }

}
