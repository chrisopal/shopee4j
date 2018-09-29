package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.api.Builders;
import com.salesmore.yak.integration.shopee.model.common.Country;
import com.salesmore.yak.integration.shopee.model.item.*;
import com.salesmore.yak.integration.shopee.model.item.request.*;
import com.salesmore.yak.integration.shopee.model.item.request.ItemUpdateBatch.ItemUpdateBatchBuilder;
import com.salesmore.yak.integration.shopee.model.item.response.*;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.salesmore.yak.integration.shopee.model.item.request.ItemUpdateBatch.ItemUpdate;

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

        List<Category> categoryList = client().item().getCategoriesByCountry(categoriesByCounty());
        logger.info("Category List By country: {}", categoryList);
        assertNotNull(categoryList);

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

        //Get Item Detail
        ItemInfo itemDetailResult = client().item().getItemDetail(itemIdRequest(itemResult.getId()));
        logger.info("Get Item Detail Result: {}", itemDetailResult);
        assertEquals(itemDetailResult.getVariations().size(), 2);

        //Add Item Variations
        VariationAddResult variationAddResult = client().item().addVariations(addVariationsRequest(itemResult.getId()));
        logger.info("Add Variation Result: {}", variationAddResult);
        assertNotNull(variationAddResult.getVariations());

        //Update Variation Price
        Long variationId = variationAddResult.getVariations().get(0).getId();
        VariationActionResult updateVariationPriceResult = client().item().updateVariationPrice(variationPrice(variationId, itemResult.getId()));
        logger.info("Update VariationPrice Result: {}", updateVariationPriceResult);
        assertEquals(updateVariationPriceResult.getPrice(), 5.5f);

        //Update Variation Stock
        VariationActionResult updateVariationStockResult = client().item().updateVariationStock(variationStock(variationId, itemResult.getId()));
        logger.info("Update VariationStock Result: {}", updateVariationStockResult);
        assertEquals(updateVariationStockResult.getStock(), new Long(40));

        //Update Variation price batch
        //updateVariationPriceBatch(variationAddResult);

        //Update Variation Stock batch
        //updateVariationStockBatch(variationAddResult);

        //Delete Variation
        VariationActionResult deleteVariationResult = client().item().deleteVariation(variationIdRequest(variationId, itemResult.getId()));
        logger.info("Delete Variation Result: {}", deleteVariationResult);
        assertEquals(deleteVariationResult.getVariationId(), variationId);


        //Insert Item Image
        ItemImagesResult itemImagesResult = client().item().insertItemImage(itemImageInsert(itemResult.getId()));
        logger.info("Item Image Insert Result: {}", itemImagesResult);
        assertNotNull(itemImagesResult.getImages());

        //Delete Item image
        client().item().deleteItemImage(itemImagesToDelete(itemResult.getId(), itemImagesResult.getImages()));

        //Update Item
        ItemResult itemResultUpdate = client().item().updateItem(itemRequestUpdate(itemResult.getId()));
        logger.info("Update Item Result: {}", itemResultUpdate);
        assertEquals(itemResultUpdate.getItem().getName(), "Lady's Clothes Updated");

        //Delete
        deleteItem(itemResult.getId());

        //assertEquals(itemResult.getItem().getCategoryId(), new Long(13026));
    }

    @Test
    void addItemWithoutVariation_thenUpdatePrice_Stock_finallyDelete() throws Exception {
        //Add Item
        ItemResult itemResult = client().item().addItem(itemRequestWithoutVariation());
        logger.info("Add Item without Variations Result: {}", itemResult);

        //update Item price
        float price = 34.56f;
        ItemUpdateActionResult itemUpdatePriceResult =  client().item().updateItemPrice(itemPrice(itemResult.getId(), price));
        logger.info("Item Update Price Result: {}", itemUpdatePriceResult);
        //assertEquals(itemUpdatePriceResult.getPrice(), price);

        //update Item stock
        Long stock = 211L;
        ItemUpdateActionResult itemUpdateStockResult =  client().item().updateItemStock(itemStock(itemResult.getId(), stock));
        logger.info("Item Update Stock Result: {}", itemUpdateStockResult);
        assertEquals(itemUpdateStockResult.getStock(), stock);

        //Delete
        deleteItem(itemResult.getId());

    }

    @Test
    void addItemImages() throws Exception {
        //Add Item image
        ItemImagesResult itemImagesAddResult = client().item().addItemImage(itemImages(1524730L));
        logger.info("Item Image Add Result: {}", itemImagesAddResult);
        assertNotNull(itemImagesAddResult.getImages());
    }

    @Test
    void getItems_andUpdatePrice_Stock_Batch() throws Exception {
        ItemsResult result = client().item().getItemList(paginationBaseRequest());
        logger.info("Get Items: {}", result);
        assertNotNull(result.getItems());
        
        //update item price batch
        updateItemPriceBatch(result.getItems());
        
        //update item stock batch
        updateItemStockBatch(result.getItems());
    }

    @Test
    void deleteItem() throws Exception {
        //deleteItem(1526039L);
    }

    void updateItemPriceBatch(List<ItemSimpleInfo> items) {
		@SuppressWarnings("rawtypes")
		ItemUpdateBatchBuilder builder = ItemUpdateBatch.builder().partnerId(PARTNER_ID).shopId(SHOP_ID).timestamp(System.currentTimeMillis()/1000);
        for(ItemSimpleInfo item : items){
            builder.item(ItemUpdate.builder().id(item.getId()).price(ThreadLocalRandom.current().nextFloat()*20).build());
        }
        List<ItemBatchResult> result = client().item().updateItemPriceBatch(builder.build());
        logger.info("Update Items Price Batch: {}", result);
        assertNotNull(result);
    }
    
    void updateItemStockBatch(List<ItemSimpleInfo> items) {
		@SuppressWarnings("rawtypes")
		ItemUpdateBatchBuilder builder = ItemUpdateBatch.builder().partnerId(PARTNER_ID).shopId(SHOP_ID).timestamp(System.currentTimeMillis()/1000);
        for(ItemSimpleInfo item : items){
            builder.item(ItemUpdate.builder().id(item.getId()).stock(ThreadLocalRandom.current().nextLong(100, 150)).build());
        }
        List<ItemBatchResult> result = client().item().updateItemStockBatch(builder.build());
        logger.info("Update Items Stock Batch: {}", result);
        assertNotNull(result);
    }

    void updateVariationPriceBatch(VariationAddResult variationAddResult, Long itemId) throws Exception {
        @SuppressWarnings("rawtypes")
        VariationBatch.VariationBatchBuilder variationBatchBuilder = VariationBatch.builder().partnerId(PARTNER_ID).shopId(SHOP_ID).timestamp(System.currentTimeMillis()/1000);
        for( Variation variation : variationAddResult.getVariations() ) {
            variationBatchBuilder.variation(Variation.builder().id(variation.getId()).price(variation.getPrice()+0.5f).itemId(itemId).build());
        }
        List<VariationBatchResult> variationPriceBatchResult = client().item().updateVariationPriceBatch(variationBatchBuilder.build());
        logger.info("Update VariationPriceBatch Result: {}", variationPriceBatchResult);
        assertNotNull(variationPriceBatchResult);
    }

    void updateVariationStockBatch(VariationAddResult variationAddResult, Long itemId) throws Exception {
        @SuppressWarnings("rawtypes")
        VariationBatch.VariationBatchBuilder variationBatchBuilderStock = VariationBatch.builder().partnerId(PARTNER_ID).shopId(SHOP_ID).timestamp(System.currentTimeMillis() / 1000);
        for (Variation variation : variationAddResult.getVariations()) {
            variationBatchBuilderStock.variation(Variation.builder().id(variation.getId()).stock(variation.getStock() + 15).itemId(itemId).build());
        }
        List<VariationBatchResult> variationStockBatchResult = client().item().updateVariationStockBatch(variationBatchBuilderStock.build());
        logger.info("Update VariationStockBatch Result: {}", variationStockBatchResult);
        assertNotNull(variationStockBatchResult);
    }

    private ItemPrice itemPrice(Long itemId, float price) {
        return ItemPrice.builder().id(itemId)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .price(price)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }

    private ItemStock itemStock(Long itemId, Long stock) {
        return ItemStock.builder().id(itemId)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .stock(stock)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }


    private ItemImages itemImages(Long itemId) {
        return ItemImages.builder().partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .image("https://ae01.alicdn.com/kf/HTB1UonQNXXXXXXyXXXXq6xXFXXXc/Missoov-luxury-brand-designer-Women-s-Clothing-fall-winter-korean-style-mini-Dresses-knitting-dress-vestidos.jpg_640x640.jpg")
                .id(itemId)
                .build();
    }

    private ItemImageInsert itemImageInsert(Long itemId) {
        return ItemImageInsert.builder().partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .image("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-489980972_large.jpg?v=1520489299")
                .position(3)
                .id(itemId)
                .build();
    }

    private ItemImages itemImagesToDelete(Long itemId, List<String> images) throws Exception {
        return ItemImages.builder().partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .images(images)
                .id(itemId)
                .build();
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
                .timestamp(System.currentTimeMillis() / 1000)
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
                .country(Country.SG)
                .isCrossBorder(0)
                .language(Language.EN)
                .timestamp(System.currentTimeMillis() / 1000)
                .build();
    }

    private GetAttributes getAttributesRequest() {
        return GetAttributes.builder()
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis() / 1000)
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
                .timestamp(System.currentTimeMillis() / 1000)
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
                .timestamp(System.currentTimeMillis() / 1000)
                .condition("NEW")
                .build();
    }

    private Item itemRequestWithoutVariation() {
        return Item.builder().categoryId(13026L)
                .name("Lady's Clothes Updated")
                .description("Women O-Neck Elastic Cuff Long Sleeve Shirt Blouse Tops Rose\\r\\n\\r\\n\\r\\nsize bust")
                .price(12.05f)
                .stock(200L)
                .itemSku("dm1id-77830030")
                .image(Image.builder().url("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515367411_1024x1024.jpg?v=1520489296").build())
                .image(Image.builder().url("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515678037_large.jpg?v=1520489297").build())
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
                .timestamp(System.currentTimeMillis() / 1000)
                .condition("NEW")
                .build();
    }

    private AddVariation addVariationsRequest(Long itemId) {
        return AddVariation.builder()
                .timestamp(System.currentTimeMillis() / 1000)
                .shopId(SHOP_ID)
                .partnerId(PARTNER_ID)
                .itemId(itemId)
                .variation(Variation.builder().name("v-c").stock(35L).price(2.3f).sku("dm1id-56175482-c").build())
                .variation(Variation.builder().name("v-d").stock(32L).price(3.f).sku("dm1id-56175482-d").build())
                .build();
    }

    private VariationPrice variationPrice(Long variationId, Long itemId) {
        return VariationPrice.builder()
                .id(variationId)
                .itemId(itemId)
                .price(5.5f)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis() / 1000)
                .build();
    }

    private VariationIdRequest variationIdRequest(Long variationId, Long itemId) {
        return VariationIdRequest.builder()
                .id(variationId)
                .itemId(itemId)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis() / 1000)
                .build();
    }

    private VariationStock variationStock(Long variationId, Long itemId) {
        return VariationStock.builder()
                .id(variationId)
                .itemId(itemId)
                .stock(40L)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis() / 1000)
                .build();
    }
}
