package com.salesmore.yak.integration.shopee.model.discount.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

import java.util.List;

@Data
public class DiscountDetail implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a discount activity.
     */
    @JsonProperty("discount_id")
    private Long discountId;

    /**
     * Discount Name
     */
    @JsonProperty("discount_name")
    private String name;

    /**
     * The time when discount activity start.
     */
    private Long startTime;

    /**
     * The time when discount activity end. The end time must be 1 hour later than start time.
     */
    private Long endTime;

    /**
     * All Items
     */
    private List<ItemDetail> items;

    /**
     * This is to indicate whether the item list is more than one page. If this value is true,
     * you may want to continue to check next page to retrieve the rest of items.
     */
    private boolean more;
}
