package com.salesmore.yak.integration.shopee.service.domain;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.shopee.api.domain.ShopCategoryService;
import com.salesmore.yak.integration.shopee.constants.PathConstants;
import com.salesmore.yak.integration.shopee.model.PaginationBaseRequest;
import com.salesmore.yak.integration.shopee.model.shopcategory.ShopCategory;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.CategoryItems;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.ShopCategoryRequest;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.CategoryItemIds;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.CategoryItemsAdded;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.ShopCategories;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.ShopCategoryIdEntity;

import static com.google.common.base.Preconditions.checkNotNull;

public class ShopCategoryServiceImpl extends BaseRestClientService implements ShopCategoryService {

    @Override
    public CategoryItemsAdded addCategoryItems(CategoryItems categoryItems) {
        checkNotNull(categoryItems);
        return post(CategoryItemsAdded.class, uri(PathConstants.SHOP_CATEGORY_ADD_ITEMS_RELATEIVE_PATH)).entity(categoryItems).execute();
    }

    @Override
    public CategoryItemIds getCategoryItems(ShopCategoryRequest shopCategoryRequest) {
        checkNotNull(shopCategoryRequest);
        return post(CategoryItemIds.class, uri(PathConstants.SHOP_CATEGORY_GET_ITEMS_RELATEIVE_PATH)).entity(shopCategoryRequest).execute();
    }

    @Override
    public ShopCategoryIdEntity addShopCategory(ShopCategoryRequest shopCategoryRequest) {
        checkNotNull(shopCategoryRequest);
        return post(ShopCategoryIdEntity.class, uri(PathConstants.SHOP_CATEGORY_ADD_RELATEIVE_PATH)).entity(shopCategoryRequest).execute();
    }

    @Override
    public ShopCategory updateShopCategory(ShopCategoryRequest shopCategoryRequest) {
        checkNotNull(shopCategoryRequest);
        return post(ShopCategory.class, uri(PathConstants.SHOP_CATEGORY_UPDATE_RELATEIVE_PATH)).entity(shopCategoryRequest).execute();
    }

    @Override
    public ShopCategories getShopCategories(PaginationBaseRequest paginationRequest) {
        checkNotNull(paginationRequest);
        return post(ShopCategories.class, uri(PathConstants.SHOP_CATEGORY_GET_RELATEIVE_PATH)).entity(paginationRequest).execute();
    }

    @Override
    public ShopCategoryIdEntity deleteShopCategory(ShopCategoryRequest shopCategoryRequest) {
        checkNotNull(shopCategoryRequest);
        return post(ShopCategoryIdEntity.class, uri(PathConstants.SHOP_CATEGORY_DELETE_RELATEIVE_PATH)).entity(shopCategoryRequest).execute();
    }
}
