package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.api.Builders;
import com.salesmore.yak.integration.shopee.model.common.Country;
import com.salesmore.yak.integration.shopee.model.item.*;
import com.salesmore.yak.integration.shopee.model.item.request.*;
import com.salesmore.yak.integration.shopee.model.item.response.ItemIdEntity;
import com.salesmore.yak.integration.shopee.model.item.response.ItemResult;
import com.salesmore.yak.integration.shopee.model.item.response.ItemsResult;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ItemServiceTest extends AbstractTest {

    @Test
    public void getCategories() throws Exception {

        List<Category> categoryList = client().item().getCategories(itemBaseRequest());
        logger.info("Category List: {}", categoryList);
        assertNotNull(categoryList);

    }

    //TODO: NOT PASSED.
    //ClientResponseException{message={"error": "error_auth"}
    //, status=403, status-code=FORBIDDEN}
    @Test
    public void getCategoriesByCountry() throws Exception {

        //List<Category> categoryList = client().item().getCategoriesByCountry(categoriesByCounty());
        //logger.info("Category List By country: {}", categoryList);
        //assertNotNull(categoryList);

    }
    
    @Test
    public void getAttributes() throws Exception {

        List<Attribute> attributes = client().item().getAttributes(getAttributesRequest());
        logger.info("Attribute List: {}", attributes);
        assertNotNull(attributes);

    }
    
    @Test
    public void addItem_thenUpdate_finallyDelete() throws Exception {
        //Add Item
    	ItemResult itemResult = client().item().addItem(itemRequest());
    	logger.info("Add Item Result: {}", itemResult);

    	//Update Item
        ItemResult itemResultUpdate = client().item().updateItem(itemRequestUpdate(itemResult.getId()));
        logger.info("Update Item Result: {}", itemResultUpdate);
        assertEquals(itemResultUpdate.getItem().getName(), "Lady's Clothes Updated");

        //Delete
    	deleteItem(itemResult.getId());

    	//assertEquals(itemResult.getItem().getCategoryId(), new Long(13026));
    }
    
    @Test void getItems() throws Exception {
    	ItemsResult result = client().item().getItemList(paginationBaseRequest());
    	logger.info("Get Items: {}", result);
    	assertNotNull(result.getItems());
    }

    @Test
    void deleteItem() throws Exception {
        //deleteItem(1525817L);
    }

    private void deleteItem(Long itemId) throws Exception {
       ItemIdEntity idEntity = client().item().deleteItem(itemIdRequest(itemId));
        logger.info("Delete Item Result: {}", idEntity);
        assertEquals(idEntity.getId(), itemId);
    }

    private ItemIdRequest itemIdRequest(Long itemId) {
        return ItemIdRequest.builder().id(itemId)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }


    private ItemBaseRequest itemBaseRequest() {

        return Builders.itemBaseRequest()
                .language(Language.ZH_HANS)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis() / 1000)
                .build();
    }

    private CategoriesByCounty categoriesByCounty() {
        return CategoriesByCounty.builder()
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .country(Country.SG)
                .isCrossBorder(1)
                .language(Language.EN)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }

    private GetAttributes getAttributesRequest() {
        return GetAttributes.builder()
        		.partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .country(Country.SG)
                .categoryId(13026L)
                .cb(false)
                .language(Language.EN)
                .build();
    }

    private Item itemRequest() {
        return Item.builder().categoryId(13026L)
        	.name("Lady's Clothes")
        	.description("Women O-Neck Elastic Cuff Long Sleeve Shirt Blouse Tops Rose\\r\\n\\r\\n\\r\\nsize bust")
        	.price(12.05f)
        	.stock(200L)
        	.itemSku("dm1id-56175482")
        	.image(Image.builder().url("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515367411_1024x1024.jpg?v=1520489296").build())
        	.image(Image.builder().url("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515678037_large.jpg?v=1520489297").build())
        	.variation(Variation.builder().name("v-a").stock(20L).price(5.6f).sku("dm1id-56175482-a").build())
        	.variation(Variation.builder().name("v-b").stock(15L).price(4.8f).sku("dm1id-56175482-b").build())
            .attribute(AttributeValue.builder().attributeId(6746L).value("fff").build())
            .attribute(AttributeValue.builder().attributeId(6741L).value("1").build())
            .logistic(Logistic.builder().id(18003L).enabled(true).shippingFee(0.4f).free(false).build())
            .weight(1.5f)
            .packageHeight(10L)
            .packageLength(11L)
            .packageWidth(12)
            .daysToShip(10)
            .partnerId(PARTNER_ID)
            .shopId(SHOP_ID)
            .timestamp(System.currentTimeMillis()/1000)
            .condition("NEW")
            .build();
    }

    private Item itemRequestUpdate(Long itemId) {
        return Item.builder().categoryId(13026L)
        		.id(itemId)
                .name("Lady's Clothes Updated")
                .description("Women O-Neck Elastic Cuff Long Sleeve Shirt Blouse Tops Rose\\r\\n\\r\\n\\r\\nsize bust")
                .price(13.05f)
                .stock(100L)
                .itemSku("dm1id-56175482")
                .attribute(AttributeValue.builder().attributeId(6741L).value("2").build())
                .weight(3.0f)
                .packageHeight(20L)
                .packageLength(21L)
                .packageWidth(22)
                .daysToShip(10)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .condition("NEW")
                .build();
    }

    private Item itemRequest_WithWholeSale_by_Same_variation_price() {
        return Item.builder().categoryId(13026L)
                .name("Lady's Clothes Updated")
                .description("Women O-Neck Elastic Cuff Long Sleeve Shirt Blouse Tops Rose\\r\\n\\r\\n\\r\\nsize bust")
                .price(12.05f)
                .stock(200L)
                .itemSku("dm1id-77830030")
                .image(Image.builder().url("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515367411_1024x1024.jpg?v=1520489296").build())
                .image(Image.builder().url("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515678037_large.jpg?v=1520489297").build())
                .variation(Variation.builder().name("v-a").stock(20L).price(5.6f).sku("dm1id-77830030-a").build())
                .variation(Variation.builder().name("v-b").stock(15L).price(5.6f).sku("dm1id-77830030-b").build())
                .attribute(AttributeValue.builder().attributeId(6746L).value("fff").build())
                .attribute(AttributeValue.builder().attributeId(6741L).value("1").build())
                .logistic(Logistic.builder().id(18003L).enabled(true).shippingFee(0.4f).free(false).build())
                .weight(1.5f)
                .packageHeight(10L)
                .packageLength(11L)
                .packageWidth(12)
                .daysToShip(10)
                .wholesale(WholeSale.builder().min(3).max(8).unitPrice(20.9f).build())
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .condition("NEW")
                .build();
    }
}
