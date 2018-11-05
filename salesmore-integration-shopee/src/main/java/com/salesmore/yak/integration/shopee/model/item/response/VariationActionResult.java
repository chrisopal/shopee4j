package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import com.salesmore.yak.integration.shopee.model.item.Variation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class VariationActionResult extends ErrorResponse {

	private static final long serialVersionUID = 1L;
    /**
     * Unique identifier for an item.
     */
    @JsonProperty("item_id")
    private Long itemId;

    /**
     * The time when stock of the variation is updated.
     */
    @JsonProperty("modified_time")
    private Long modifiedTime;

    /**
     * Shopee's unique identifier for a variation of an item.
     */
    @JsonProperty("variation_id")
    private Long variationId;

    /**
     * Price updated
     */
    private float price;

    /**
     * Stock Updated
     */
    private Long stock;
}
