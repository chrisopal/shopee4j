package com.salesmore.yak.integration.shopee.service.shop;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.shopee.api.domain.ShopService;
import com.salesmore.yak.integration.shopee.constants.PathConstants;
import com.salesmore.yak.integration.shopee.model.shop.request.BaseRequest;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopAuth;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopInfoUpdate;
import com.salesmore.yak.integration.shopee.model.shop.response.ShopInfo;
import com.salesmore.yak.integration.shopee.model.shop.response.ShopInfoUpdatedResult;
import com.salesmore.yak.integration.shopee.model.shop.response.ShopPerformance;
import com.salesmore.yak.integration.shopee.utils.HashingUtils;

import static com.google.common.base.Preconditions.checkNotNull;

public class ShopServiceImpl extends BaseRestClientService implements ShopService {

    @Override
    public ShopInfo getShopInfo(BaseRequest request) {
        checkNotNull(request);
        return post(ShopInfo.class, uri(PathConstants.SHOP_GET_RELATIVE_PATH)).entity(request).execute();
    }

    @Override
    public ShopInfoUpdatedResult updateShopInfo(ShopInfoUpdate request) {
        checkNotNull(request);
        return post(ShopInfoUpdatedResult.class, uri(PathConstants.SHOP_UPDATE_RELATIVE_PATH)).entity(request).execute();
    }

    @Override
    public ShopPerformance getShopPerformance(BaseRequest request) {
        checkNotNull(request);
        return post(ShopPerformance.class, uri(PathConstants.SHOP_PERFORMANCE_RELATIVE_PATH)).entity(request).execute();
    }


    @Override
    public void authorizeShop(ShopAuth auth) {
        checkNotNull(auth);
        checkNotNull(auth.getId());
        checkNotNull(auth.getRedirectUrl());
        get(Void.class, uri(PathConstants.SHOP_AUTH_RELATIVE_PATH))
                .param(PathConstants.QUERY_PARAM_ID, auth.getId())
                .param(PathConstants.QUERY_PARAM_TOKEN, generateAuthToken(auth))
                .param(PathConstants.QUERY_PARAM_REDIRECT, auth.getToken())
                .execute();
    }

    @Override
    public void cancelAuthorizeShop(ShopAuth auth) {
        checkNotNull(auth);
        checkNotNull(auth.getId());
        checkNotNull(auth.getRedirectUrl());
        get(Void.class, uri(PathConstants.SHOP_CANCEL_AUTH_RELATIVE_PATH))
                .param(PathConstants.QUERY_PARAM_ID, auth.getId())
                .param(PathConstants.QUERY_PARAM_TOKEN, generateAuthToken(auth))
                .param(PathConstants.QUERY_PARAM_REDIRECT, auth.getToken())
                .execute();
    }

    private String generateAuthToken(ShopAuth auth) {
        return HashingUtils.sha256Hashing(String.format("%s%s", auth.getId(), auth.getRedirectUrl()));
    }
}
