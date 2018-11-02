package com.salesmore.yak.integration.shopee.model.shopcategory.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

import java.util.List;

@Data
public class CategoryItemsAdded implements ModelEntity {

    public static final long serialVersionUID = 1L;

    @JsonProperty("invalid_item_id")
    private List<Long> invalidItemIds;

    /**
     * ShopCategory's unique identifier.
     */
    @JsonProperty("shop_category_id")
    private Long shopCategoryId;

    /**
     * Number of item in the shop category.
     */
    private long count;

    /**
     * The identifier for an API request for error tracking
     */
    @JsonProperty("request_id")
    private String requestId;
}
