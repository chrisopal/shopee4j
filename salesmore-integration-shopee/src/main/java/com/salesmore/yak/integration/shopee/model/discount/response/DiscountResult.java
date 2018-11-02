package com.salesmore.yak.integration.shopee.model.discount.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;

@Data
public class DiscountResult extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a discount activity.
     */
    @JsonProperty("discount_id")
    private Long discountId;

    /**
     * The number of items that add successfully.
     */
    private Long count;

    /**
     * Warning Message
     */
    private String warning;

    /**
     * The identifier for an API request for error tracking
     */
    @JsonProperty("request_id")
    private String requestId;

}
