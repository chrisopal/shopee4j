package com.salesmore.yak.integration.shopee.service.domain;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.shopee.api.domain.ItemService;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.PaginationBaseRequest;
import com.salesmore.yak.integration.shopee.model.item.Attribute;
import com.salesmore.yak.integration.shopee.model.item.Category;
import com.salesmore.yak.integration.shopee.model.item.request.*;


import static com.google.common.base.Preconditions.checkArgument;
import static com.salesmore.yak.integration.shopee.constants.PathConstants.*;
import static com.salesmore.yak.integration.shopee.model.item.Attribute.Attributes;
import com.salesmore.yak.integration.shopee.model.item.Category.Categories;
import com.salesmore.yak.integration.shopee.model.item.response.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.salesmore.yak.integration.shopee.model.item.response.VariationBatchResult.VariationBatchesResult;
import static com.salesmore.yak.integration.shopee.model.item.response.ItemBatchResult.ItemUpdateBatchesResult;


public class ItemServiceImpl extends BaseRestClientService implements ItemService{

    @Override
    public ItemResult addItem(Item item) {
        checkNotNull(item);
        checkArgument( item.getCategoryId() !=null && StringUtils.isEmpty(item.getName()));
        return post(ItemResult.class, uri(ITEM_ADD_RELATIVE_PATH)).entity(item).executeWithErrorResponse();
    }

    @Override
    public ItemResult updateItem(Item item) {
        checkNotNull(item);
        checkNotNull(item.getId());
        return post(ItemResult.class, uri(ITEM_UPDATE_RELATIVE_PATH)).entity(item).executeWithErrorResponse();
    }

    @Override
    public ItemResult getItemDetail(ItemIdRequest idRequest) {
        checkNotNull(idRequest);
        checkNotNull(idRequest.getId());
        return post(ItemResult.class, uri(ITEM_GET_DETAIL_RELATIVE_PATH)).entity(idRequest).execute();
    }

    @Override
    public ItemsResult getItemList(PaginationBaseRequest queryRequest) {
        checkNotNull(queryRequest);
        return post(ItemsResult.class, uri(ITEM_GET_LIST_RELATIVE_PATH)).entity(queryRequest).execute();
    }

    @Override
    public ItemIdEntity deleteItem(ItemIdRequest idRequest) {
        checkNotNull(idRequest);
        checkNotNull(idRequest.getId());
        return post(ItemIdEntity.class, uri(ITEM_DELETE_RELATIVE_PATH)).entity(idRequest).execute();
    }

    @Override
    public ItemActionResultWrapper updateItemPrice(ItemPrice itemPrice) {
        checkNotNull(itemPrice);
        checkArgument(itemPrice.getPrice() != 0);
        return post(ItemActionResultWrapper.class, uri(ITEM_UPDATE_PRICE_RELATIVE_PATH)).entity(itemPrice).execute();
    }

    @Override
    public ItemActionResultWrapper updateItemStock(ItemStock itemStock) {
        checkNotNull(itemStock);
        checkArgument(itemStock.getStock() != null);
        return post(ItemActionResultWrapper.class, uri(ITEM_UPDATE_STOCK_RELATIVE_PATH)).entity(itemStock).execute();

    }

    @Override
    public List<ItemBatchResult> updateItemPriceBatch(ItemUpdateBatch updateBatch) {
        checkNotNull(updateBatch);
        checkNotNull(updateBatch.getItems());
        return post(ItemUpdateBatchesResult.class, uri(ITEM_BATCH_UPDATE_PRICE_PATH)).entity(updateBatch).executeWithErrorResponse().getList();
    }

    @Override
    public List<ItemBatchResult> updateItemStockBatch(ItemUpdateBatch updateBatch) {
        checkNotNull(updateBatch);
        checkNotNull(updateBatch.getItems());
        return post(ItemUpdateBatchesResult.class, uri(ITEM_BATCH_UPDATE_STOCK_PATH)).entity(updateBatch).executeWithErrorResponse().getList();

    }

    @Override
    public ItemImagesResult addItemImage(ItemImages itemImages) {
        checkNotNull(itemImages);
        checkArgument(itemImages.getImages() != null && itemImages.getImages().size() < 10);
        return post(ItemImagesResult.class, uri(ITEM_IMAGE_ADD_RELATIVE_PATH)).entity(itemImages).executeWithErrorResponse();
    }

    @Override
    public void deleteItemImage(ItemImages itemImages) {
        checkNotNull(itemImages);
        checkArgument(itemImages.getImages() != null || itemImages.getPositions() != null);
        post(Void.class, uri(ITEM_IMAGE_DELETE_RELATIVE_PATH)).entity(itemImages).executeWithErrorResponse();
    }

    @Override
    public ItemImagesResult insertItemImage(ItemImageInsert imageInsert) {
        checkNotNull(imageInsert);
        checkArgument(imageInsert.getPosition() != null && !StringUtils.isEmpty(imageInsert.getImage()));
        return post(ItemImagesResult.class, uri(ITEM_IMAGE_ADD_RELATIVE_PATH)).entity(imageInsert).executeWithErrorResponse();
    }

    @Override
    public List<Attribute> getAttributes(GetAttributes request) {
        checkNotNull(request);
        checkArgument(request.getCategoryId() != null);
        return post(Attributes.class, uri(ITEM_ATTRIBUTES_GET_PATH)).entity(request).execute().getList();
    }

    @Override
    public List<Category> getCategories(BaseRequest request) {
        checkNotNull(request);
        return post(Categories.class, uri(ITEM_CATEGORY_GET_PATH)).entity(request).execute().getList();
    }

    @Override
    public List<Category> getCategoriesByCountry(CategoriesByCounty request) {
        checkNotNull(request);
        checkArgument(request.getCountry() != null);
        return post(Categories.class, uri(ITEM_CATEGORY_GET_BY_COUNTRY)).entity(request).execute().getList();
    }

    @Override
    public VariationAddResult addVariations(AddVariation addVariationRequest) {
        checkNotNull(addVariationRequest);
        checkArgument(addVariationRequest.getItemId() != null && addVariationRequest.getVariations() != null );
        return post(VariationAddResult.class, uri(ITEM_VARIATIONS_ADD_PATH)).entity(addVariationRequest).executeWithErrorResponse();
    }

    @Override
    public VariationActionResult deleteVariation(VariationIdRequest idRequest) {
        checkNotNull(idRequest);
        checkArgument(idRequest.getVariationId() != null);
        return post(VariationActionResult.class, uri(ITEM_VARIATIONS_DELETE_RELATIVE_PATH)).entity(idRequest).execute();
    }

    @Override
    public VariationActionResultWrapper updateVariationPrice(VariationPrice variationPrice) {
        checkNotNull(variationPrice);
        checkArgument(variationPrice.getVariationId() != null);
        return post(VariationActionResultWrapper.class, uri(ITEM_VARIATIONS_UPDATE_PRICE_PATH)).entity(variationPrice).execute();

    }

    @Override
    public VariationActionResultWrapper updateVariationStock(VariationStock variationStock) {
        checkNotNull(variationStock);
        checkArgument(variationStock.getVariationId() != null);
        return post(VariationActionResultWrapper.class, uri(ITEM_VARIATIONS_UPDATE_STOCK_PATH)).entity(variationStock).execute();

    }

    @Override
    public List<VariationBatchResult> updateVariationPriceBatch(VariationBatch variationBatch) {
        checkNotNull(variationBatch);
        checkNotNull(variationBatch.getVariations());
        return post(VariationBatchesResult.class, uri(ITEM_VARIATIONS_BATCH_UPDATE_PRICE_PATH)).entity(variationBatch).executeWithErrorResponse().getList();
    }

    @Override
    public List<VariationBatchResult> updateVariationStockBatch(VariationBatch variationBatch) {
        checkNotNull(variationBatch);
        checkNotNull(variationBatch.getVariations());
        return post(VariationBatchesResult.class, uri(ITEM_VARIATIONS_BATCH_UPDATE_STOCK_PATH)).entity(variationBatch).executeWithErrorResponse().getList();

    }
}
