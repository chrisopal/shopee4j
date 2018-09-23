package com.salesmore.yak.integration.shopee.api.domain;

import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.shopee.model.PaginationBaseRequest;
import com.salesmore.yak.integration.shopee.model.shopcategory.ShopCategory;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.CategoryItems;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.ShopCategoryRequest;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.CategoryItemIds;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.CategoryItemsAdded;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.ShopCategories;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.ShopCategoryIdEntity;

public interface ShopCategoryService extends RestService {

    /**
     * Add Category Items
     *
     * @param categoryItems category item to add
     * @return category item added result
     */
    CategoryItemsAdded addCategoryItems(CategoryItems categoryItems);

    /**
     * Get Category Item Ids
     *
     * @param shopCategoryRequest shop category request
     * @return retrieved category item ids
     */
    CategoryItemIds getCategoryItems(ShopCategoryRequest shopCategoryRequest);

    /**
     * Add Shop Category
     *
     * @param shopCategoryRequest shop category request
     * @return shop category id
     */
    ShopCategoryIdEntity addShopCategory(ShopCategoryRequest shopCategoryRequest);

    /**
     * Update Shop Category
     *
     * @param shopCategoryRequest shop category request
     * @return shop category
     */
    ShopCategory updateShopCategory(ShopCategoryRequest shopCategoryRequest);

    /**
     * Get Shop Categories
     *
     * @param paginationRequest request with pagination info
     * @return ShopCategories
     */
    ShopCategories getShopCategories(PaginationBaseRequest paginationRequest);

    /**
     * Delete Shop Category
     *
     * @param shopCategoryRequest shop category request
     * @return ShopCategoryIdEntity
     */
    ShopCategoryIdEntity deleteShopCategory(ShopCategoryRequest shopCategoryRequest);


}
