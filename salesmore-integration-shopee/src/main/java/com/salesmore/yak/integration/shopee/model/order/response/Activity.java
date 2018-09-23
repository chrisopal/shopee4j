package com.salesmore.yak.integration.shopee.model.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
public class Activity implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * ID of activity.
     */
    @JsonProperty("activity_id")
    private Long id;

    /**
     * Type of activity.
     */
    @JsonProperty("activity_type")
    private String type;

    /**
     * The price used to participate activity.
     */
    @JsonProperty("original_price")
    private float originalPrice;

    /**
     * The price used to participate activity.
     */
    @JsonProperty("discounted_price")
    private float discountedPrice;

    /**
     * This object contains the items in this activity.
     */
    @Singular
    private List<OrderItemSimple> items;
}
