package com.salesmore.yak.integration.shopee.model.discount.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

import java.util.List;

@Data
public class ItemDetail implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Id of the Item
     */
    @JsonProperty("item_id")
    private Long id;

    /**
     * Name of the item in local language.
     */
    @JsonProperty("item_name")
    private String name;


    /**
     * The discount price of the item. If the item has no variation, this param is necessary.
     */
    @JsonProperty("item_promotion_price")
    private float promotionPrice;

    /**
     * The original price before discount of the item. If there is variation, this value is 0.
     */
    @JsonProperty("item_original_price")
    private float originalPrice;

    /**
     * The max number of this product in the promotion price.
     */
    @JsonProperty("purchase_limit")
    private Long purchaseLimit;

    /**
     * The current stock quantity of the item.
     */
    private Long stock;

    /**
     * Discount Item Variations
     */
    private List<VariationDetail> variations;
}
