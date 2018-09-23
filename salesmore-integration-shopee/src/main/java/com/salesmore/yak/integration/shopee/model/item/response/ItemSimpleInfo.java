package com.salesmore.yak.integration.shopee.model.item.response;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.item.ItemStatus;
import com.salesmore.yak.integration.shopee.model.item.Variation;
import lombok.Data;

import java.util.List;

@Data
public class ItemSimpleInfo implements ModelEntity {

    public static final long serialVersionUID = 1L;



    /**
     * Item Id for the result
     */
    @JsonProperty("item_id")
    private Long id;

    /**
     * shop id of the item
     */
    @JsonProperty("shopid")
    private Long shopId;

    /**
     * Status for the Item
     */
    private ItemStatus status;

    /**
     * Timestamp that indicates the last time that there was a change
     * in value of the item, such as price/stock change.
     */
    @JsonProperty("update_time")
    private Long updateTime;

    /**
     * An item SKU (stock keeping unit) is an identifier defined by a seller,
     * sometimes called parent SKU.
     */
    @JsonProperty("item_sku")
    private String itemSku;


    /**
     * The variation of item is to list out all models of this product
     */
    private List<Variation> variations;
}
