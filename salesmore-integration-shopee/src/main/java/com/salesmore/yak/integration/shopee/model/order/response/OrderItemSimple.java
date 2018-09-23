package com.salesmore.yak.integration.shopee.model.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

@Data
public class OrderItemSimple implements ModelEntity {

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
     * The number of identical items purchased at the same time by
     * the same buyer from one listing/item.
     */
    @JsonProperty("quantity_purchased")
    protected Long quantityPurchased;

    /**
     * The price used to participate activity.
     */
    @JsonProperty("original_price")
    protected float originalPrice;
}
