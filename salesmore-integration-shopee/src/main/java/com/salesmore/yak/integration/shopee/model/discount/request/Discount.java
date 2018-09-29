package com.salesmore.yak.integration.shopee.model.discount.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Discount extends BaseRequest {
	
	private static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a discount activity.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
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
    @JsonProperty("start_time")
    private Long startTime;

    /**
     * The time when discount activity end. The end time must be 1 hour later than start time.
     */
    @JsonProperty("end_time")
    private Long endTime;

    /**
     * All Items
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Singular
    private List<DiscountItem> items;
}
