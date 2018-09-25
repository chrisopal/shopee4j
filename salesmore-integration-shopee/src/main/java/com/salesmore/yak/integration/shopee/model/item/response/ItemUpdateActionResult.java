package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.ToString;


@Data
@ToString(callSuper = true)
public class ItemUpdateActionResult extends ErrorResponse {

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
     * Price updated
     */
    private float price;

    /**
     * Stock Updated
     */
    private Long stock;
}
