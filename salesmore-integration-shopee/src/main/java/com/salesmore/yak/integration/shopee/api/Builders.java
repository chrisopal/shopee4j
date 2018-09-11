package com.salesmore.yak.integration.shopee.api;

import com.salesmore.yak.integration.shopee.model.shop.request.BaseRequest;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopInfoUpdate;

/**
 * Utility Class to easily access all client Builders to manage model build.
 *
 */
public class Builders {

    /**
     * Get Builder to ShopInfo Request
     *
     * @return article create model builder
     */
    public static BaseRequest.BaseRequestBuilder baseRequest() { return BaseRequest.builder(); }


    /**
     * Get Builder to ShopInfo Update creation
     *
     * @return article create model builder
     */
    public static ShopInfoUpdate.ShopInfoUpdateBuilder shopInfoUpdate() { return ShopInfoUpdate.builder(); }

}
