package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.api.Builders;
import com.salesmore.yak.integration.shopee.model.PaginationBaseRequest;
import com.salesmore.yak.integration.shopee.model.PaginationBaseRequest.PaginationBaseRequestBuilder;
import com.salesmore.yak.integration.shopee.model.common.ShopCategoryStatus;
import com.salesmore.yak.integration.shopee.model.shopcategory.ShopCategory;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.CategoryItems;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.CategoryItems.CategoryItemsBuilder;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.ShopCategoryIdRequest;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.ShopCategoryRequest;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.ShopCategoryRequest.ShopCategoryRequestBuilder;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.CategoryItemId;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.CategoryItemsAdded;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.ShopCategories;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.ShopCategoryIdEntity;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ShopCategoryServiceTest extends AbstractTest {

    @Test
    public void getItems() throws Exception {
        //get items
        List<CategoryItemId> categoryItemIdList = client().shopCategory().getCategoryItems(shopCategoryIdRequest(14557L));
        logger.info("Get Items Result: {}", categoryItemIdList);
        assertNotNull(categoryItemIdList);
    }
    
    @Test
    public void addShopCategory_thenUpdateShopCategory_thenGetShopCategory_thenAddItems_thenGetItems_finallyDeleteShopCategory() throws Exception {
		//add shop category
    	ShopCategoryIdEntity idEntity = client().shopCategory().addShopCategory(shopCategoryRequest("api_test", 18L, null, null));
		logger.info("idEntity: {}", idEntity);
		//assertNotNull(idEntity.getId());

		//update shop category
		ShopCategory shopCategory = client().shopCategory().updateShopCategory(shopCategoryRequest("api_test_1", 15L, idEntity.getId(), ShopCategoryStatus.NORMAL));
		logger.info("Updated Shop Category: {}", shopCategory);
		//assertEquals(shopCategory.getName(), "api_test_1");
		//assertEquals(shopCategory.getStatus(), ShopCategoryStatus.NORMAL);

		//get shop categories
		ShopCategories shopCategories = client().shopCategory().getShopCategories(paginationBaseRequest());
		logger.info("ShopCategory List: {}", shopCategories);

		//add items
    	CategoryItemsAdded result = client().shopCategory().addCategoryItems(categoryItems(idEntity.getId()));
        logger.info("Add Items Result: {}", result);
        //assertEquals(result.getShopCategoryId(), idEntity.getId());

        //get items
		List<CategoryItemId> categoryItemIdList = client().shopCategory().getCategoryItems(shopCategoryIdRequest(idEntity.getId()));
		logger.info("Get Items Result: {}", categoryItemIdList);
		//assertEquals(categoryItemIdList.size(), 2);

		//delete shop category
		ShopCategoryIdEntity idEntityDelete = client().shopCategory().deleteShopCategory(shopCategoryIdRequest(idEntity.getId()));
		logger.info("idEntityDelete: {}", idEntityDelete);
		assertEquals(idEntityDelete.getId(), idEntity.getId());
    }

    @SuppressWarnings("rawtypes")
	public static CategoryItems categoryItems(Long shopCategoryId) {
    	return ((CategoryItemsBuilder) Builders.categoryItems()
    			.shopId(SHOP_ID)
    			.partnerId(PARTNER_ID)
    			.timestamp(System.currentTimeMillis()/1000))
    			.shopCategoryId(shopCategoryId)
    			.item(1L)
    			.item(2L)
    			.build();
    }
    
    @SuppressWarnings("rawtypes")
    public static ShopCategoryRequest shopCategoryRequest(String name, Long sortWeight, Long shopCategoryId, ShopCategoryStatus status) {
    	return ((ShopCategoryRequestBuilder) Builders.shopCategoryRequest()
    			.shopId(SHOP_ID)
    			.partnerId(PARTNER_ID)
    			.timestamp(System.currentTimeMillis()/1000))
    			.name(name)
    			.sortWeight(sortWeight)
                .shopCategoryId(shopCategoryId)
    			.status(status)
    			.build();
    }

    public static ShopCategoryIdRequest shopCategoryIdRequest(Long shopCategoryId) {
    	return  Builders.shopCategoryIdRequest()
				.id(shopCategoryId)
				.partnerId(PARTNER_ID)
				.shopId(SHOP_ID)
				.timestamp(System.currentTimeMillis()/1000)
				.build();
	}

}
