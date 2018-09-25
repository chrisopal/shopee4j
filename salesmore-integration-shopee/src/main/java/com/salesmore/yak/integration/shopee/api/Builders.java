package com.salesmore.yak.integration.shopee.api;

import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.PaginationBaseRequest;
import com.salesmore.yak.integration.shopee.model.image.request.ImageUpload;
import com.salesmore.yak.integration.shopee.model.item.request.CategoriesByCounty;
import com.salesmore.yak.integration.shopee.model.item.request.GetAttributes;
import com.salesmore.yak.integration.shopee.model.item.request.ItemBaseRequest;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopAuth;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopInfoUpdate;
import com.salesmore.yak.integration.shopee.model.shopcategory.ShopCategory;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.CategoryItems;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.ShopCategoryIdRequest;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.ShopCategoryRequest;

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
    @SuppressWarnings("rawtypes")
	public static BaseRequest.BaseRequestBuilder baseRequest() { return BaseRequest.builder(); }


    /**
     * Get Builder to ShopInfo Update creation
     *
     * @return shop info update builder
     */
    @SuppressWarnings("rawtypes")
	public static ShopInfoUpdate.ShopInfoUpdateBuilder shopInfoUpdate() { return ShopInfoUpdate.builder(); }

    /**
     * Get Builder to Shop Authorization creation
     *
     * @return shop auth builder builder
     */
    public static ShopAuth.ShopAuthBuilder shopAuth() { return ShopAuth.builder(); }
    
    /**
     * Get CategoryItems Builder
     * 
     * @return builder
     */
    @SuppressWarnings("rawtypes")
	public static CategoryItems.CategoryItemsBuilder categoryItems() {
    	return CategoryItems.builder();
	}
    
    /**
     * Get ShopCategory Request Builder
     * 
     * @return builder
     */
    @SuppressWarnings("rawtypes")
	public static ShopCategoryRequest.ShopCategoryRequestBuilder shopCategoryRequest() {
    	return ShopCategoryRequest.builder();
    }

    /**
     * Get ShopCategoryIdRequest Builder
     *
     * @return builder
     */
    public static ShopCategoryIdRequest.ShopCategoryIdRequestBuilder shopCategoryIdRequest() {
        return ShopCategoryIdRequest.builder();
    }
    
    /**
     * Get PaginationBaseRequest Builder
     *
     * @return builder
     */
    @SuppressWarnings("rawtypes")
	public static PaginationBaseRequest.PaginationBaseRequestBuilder paginationBaseRequest() {
    	return PaginationBaseRequest.builder();
    }

    /**
     * Get ItemBaseRequest Builder
     *
     * @return builder
     */
    public static ItemBaseRequest.ItemBaseRequestBuilder itemBaseRequest() {
        return ItemBaseRequest.builder();
    }

    /**
     * Get CategoriesByCounty Builder
     *
     * @return builder
     */
    public static CategoriesByCounty.CategoriesByCountyBuilder categoriesByCounty() {
        return CategoriesByCounty.builder();
    }
    
    /**
     * Get GetAttributes Builder
     *
     * @return builder
     */
    public static GetAttributes.GetAttributesBuilder getAttributeRequest() {
    	return GetAttributes.builder();
	}


    /**
     * Get ImageUpload Builder
     *
     * @return builder
     */
	public static ImageUpload.ImageUploadBuilder imageUpload() {
        return ImageUpload.builder();
    }
}
