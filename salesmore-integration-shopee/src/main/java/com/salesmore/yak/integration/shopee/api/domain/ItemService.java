package com.salesmore.yak.integration.shopee.api.domain;

import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.PaginationBaseRequest;
import com.salesmore.yak.integration.shopee.model.item.Attribute;
import com.salesmore.yak.integration.shopee.model.item.Category;
import com.salesmore.yak.integration.shopee.model.item.request.*;
import com.salesmore.yak.integration.shopee.model.item.response.*;

import java.util.List;

public interface ItemService extends RestService {

    /**
     * Add an Item
     *
     * @param item to add
     * @return item result
     */
    ItemResult addItem(Item item);

    /**
     * Update an Item
     *
     * @param item to update
     * @return item result
     */
    ItemResult updateItem(Item item);

    /**
     * Get Item Detail
     *
     * @param idRequest item it to get
     * @return item result
     */
    ItemInfo getItemDetail(ItemIdRequest idRequest);


    /**
     * Get Item List
     * Can be user through getList() to get List<Item> and .hasMore() to check if to load more
     *
     * @param queryRequest query
     * @return ListResult
     */
    ItemsResult getItemList(PaginationBaseRequest queryRequest);

    /**
     * Delete an Item
     *
     * @param idRequest item it to delete
     * @return delete result
     */
    ItemIdEntity deleteItem(ItemIdRequest idRequest);

    /**
     * Add Item Images
     *
     * @param itemImages item images to add
     * @return images result
     */
    ItemImagesResult addItemImage(ItemImages itemImages);

    /**
     * Delete Item Images with list of image urls or image positions
     *
     * @param itemImages item images to delete
     */
    void deleteItemImage(ItemImages itemImages);

    /**
     * Insert Image with URL and Position
     *
     * @param imageInsert images to insert
     * @return images after insert
     */
    ItemImagesResult insertItemImage(ItemImageInsert imageInsert);

    /**
     * Get Attributes
     *
     * @param request get attributes
     * @return list of attribute
     */
    List<Attribute> getAttributes(GetAttributes request);

    /**
     * Get Categories
     *
     * @param request base request with minimum parameters
     * @return list of category
     */
    List<Category> getCategories(ItemBaseRequest request);

    /**
     * Get Categories By Country
     *
     * @param request request with country code
     * @return list of category
     */
    List<Category> getCategoriesByCountry(CategoriesByCounty request);

    /**
     * Update Item Price
     *
     * @param itemPrice item price to update
     * @return action result
     */
    ItemUpdateActionResult updateItemPrice(ItemPrice itemPrice);

    /**
     * Update Item Stock
     *
     * @param itemStock item stock to update
     * @return action result
     */
    ItemUpdateActionResult updateItemStock(ItemStock itemStock);

    /**
     * Update Item Price Batch
     *
     * @param updateBatch price update batch
     * @return batch result
     */
    ItemBatchResult updateItemPriceBatch(ItemUpdateBatch updateBatch);

    /**
     * Update Item Stock Batch
     *
     * @param updateBatch stock update batch
     * @return batch result
     */
    ItemBatchResult updateItemStockBatch(ItemUpdateBatch updateBatch);

    /**
     * Add a Variation to Item
     *
     * @param addVariationRequest variation request
     * @return result
     */
    VariationAddResult addVariations(AddVariation addVariationRequest);

    /**
     * Delete a Variation
     *
     * @param idRequest id to delete
     * @return action result
     */
    VariationActionResult deleteVariation(VariationIdRequest idRequest);

    /**
     * Update Variation Price
     *
     * @param variationPrice variation price
     * @return
     */
    VariationActionResult updateVariationPrice(VariationPrice variationPrice);

    /**
     * Update Variation Stock
     *
     * @param variationStock variation stock
     * @return action result
     */
    VariationActionResult updateVariationStock(VariationStock variationStock);

    /**
     * Update VariationPrice Batch
     *
     * @param variationBatch batch request
     * @return batch result
     */
    VariationBatchResult updateVariationPriceBatch(VariationBatch variationBatch);

    /**
     * Update VariationStock Batch
     *
     * @param variationBatch batch request
     * @return batch result
     */
    VariationBatchResult updateVariationStockBatch(VariationBatch variationBatch);
}
