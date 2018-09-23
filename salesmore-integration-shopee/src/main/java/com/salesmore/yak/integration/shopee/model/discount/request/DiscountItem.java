package com.salesmore.yak.integration.shopee.model.discount.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class DiscountItem {

    /**
     * Id of the Item
     */
    @JsonProperty("item_id")
    private Long id;

    /**
     * The discount price of the item. If the item has no variation, this param is necessary.
     */
    @JsonProperty("item_promotion_price")
    private float promotionPrice;

    /**
     * The max number of this product in the promotion price.
     */
    @JsonProperty("purchase_limit")
    private Long purchaseLimit;

    @Singular
    private List<DiscountVariation> variations;

}
