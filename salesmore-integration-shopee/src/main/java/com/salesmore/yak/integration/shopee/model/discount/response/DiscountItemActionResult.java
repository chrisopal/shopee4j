package com.salesmore.yak.integration.shopee.model.discount.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;

@Data
public class DiscountItemActionResult extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a discount activity.
     */
    @JsonProperty("discount_id")
    private Long discountId;

    /**
     * Shopee's unique identifier for an item.
     */
    @JsonProperty("item_id")
    private Long itemId;

    /**
     * Shopee's unique identifier for a variation of an item.
     */
    @JsonProperty("variation_id")
    private Long variationId;

    /**
     * The time when discount is updated.
     */
    @JsonProperty("modify_time")
    private Long modifyTime;

    /**
     * The identifier for an API request for error tracking
     */
    @JsonProperty("request_id")
    private String requestId;

}
