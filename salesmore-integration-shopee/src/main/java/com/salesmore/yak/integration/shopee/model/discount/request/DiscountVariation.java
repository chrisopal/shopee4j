package com.salesmore.yak.integration.shopee.model.discount.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscountVariation implements ModelEntity {

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
}
