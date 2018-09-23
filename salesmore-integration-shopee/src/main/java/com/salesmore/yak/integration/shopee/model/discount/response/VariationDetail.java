package com.salesmore.yak.integration.shopee.model.discount.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

@Data
public class VariationDetail implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * unique identifier for a variation of an item
     */
    @JsonProperty("variation_id")
    private Long id;

    /**
     * The discount price of the item.
     */
    @JsonProperty("variation_promotion_price")
    private float promotionPrice;

    /**
     * Name of the variation that belongs to the same item.
     * A seller can offer variations of the same item.
     */
    @JsonProperty("variation_name")
    private String name;


    /**
     * The original price of the variation in the listing currency.
     */
    @JsonProperty("variation_original_price")
    private float originalPrice;

    /**
     * The current stock quantity of the variation in the listing currency.
     */
    @JsonProperty("variation_stock")
    private Long stock;
}
