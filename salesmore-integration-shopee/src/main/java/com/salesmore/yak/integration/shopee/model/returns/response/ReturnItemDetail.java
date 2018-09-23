package com.salesmore.yak.integration.shopee.model.returns.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

import java.util.List;

@Data
public class ReturnItemDetail implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a discount item.
     */
    @JsonProperty("Item_id")
    private Long id;

    /**
     * Shopee's unique identifier for a variation of an item.
     */
    @JsonProperty("variation_id")
    protected Long variationId;

    /**
     * Name of the item in local language.
     */
    private String name;

    /**
     * The price of Item.
     */
    @JsonProperty("item_price")
    private float itemPrice;

    /**
     * Amount of this item.
     */
    private Long amount;


    /**
     * Image URLs that seller provide. Seller can upload up 3 images at most.
     */
    private List<String> images;


}
