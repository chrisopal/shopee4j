package com.salesmore.yak.integration.shopee.api.domain;

import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopAuth;
import com.salesmore.yak.integration.shopee.model.shop.response.ShopInfo;
import com.salesmore.yak.integration.shopee.model.shop.request.BaseRequest;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopInfoUpdate;
import com.salesmore.yak.integration.shopee.model.shop.response.ShopInfoUpdatedResult;
import com.salesmore.yak.integration.shopee.model.shop.response.ShopPerformance;

public interface ShopService extends RestService {

    /**
     * Get shop Info by request parameters
     *
     * @param request shop info request body
     * @return shop info with given request parameters
     */
    ShopInfo getShopInfo(BaseRequest request);

    /**
     * Update Shop Info
     *
     * @param request shop info updated request
     * @return shop info updated response
     */
    ShopInfoUpdatedResult updateShopInfo(ShopInfoUpdate request);

    /**
     * Get Shop Performance Thresholds
     *
     * @param request shop info
     * @return performance data
     */
    ShopPerformance getShopPerformance(BaseRequest request);

    /**
     * Authorize Shop
     *
     * @param auth request info
     */
    void authorizeShop(ShopAuth auth);

    /**
     * Cancel Authorize Shop
     *
     * @param auth request info
     */
    void cancelAuthorizeShop(ShopAuth auth);
}
