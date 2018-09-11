package com.salesmore.yak.integration.shopee.api.domain;

import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.shopee.model.shop.result.ShopInfo;
import com.salesmore.yak.integration.shopee.model.shop.request.BaseRequest;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopInfoUpdate;
import com.salesmore.yak.integration.shopee.model.shop.result.ShopInfoUpdatedResult;

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
     * @return shop info updated result
     */
    ShopInfoUpdatedResult updateShopInfo(ShopInfoUpdate request);


}
