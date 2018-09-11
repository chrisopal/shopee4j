package com.salesmore.yak.integration.shopee.service.shop;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.shopee.api.domain.ShopService;
import com.salesmore.yak.integration.shopee.constants.PathConstants;
import com.salesmore.yak.integration.shopee.model.shop.result.ShopInfo;
import com.salesmore.yak.integration.shopee.model.shop.request.BaseRequest;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopInfoUpdate;
import com.salesmore.yak.integration.shopee.model.shop.result.ShopInfoUpdatedResult;

public class ShopServiceImpl extends BaseRestClientService implements ShopService {

    @Override
    public ShopInfo getShopInfo(BaseRequest request) {
        return post(ShopInfo.class, uri(PathConstants.SHOP_GET_RELATIVE_PATH)).entity(request).execute();
    }

    @Override
    public ShopInfoUpdatedResult updateShopInfo(ShopInfoUpdate request) {
        return post(ShopInfoUpdatedResult.class, uri(PathConstants.SHOP_UPDATE_RELATIVE_PATH)).entity(request).execute();
    }
}
