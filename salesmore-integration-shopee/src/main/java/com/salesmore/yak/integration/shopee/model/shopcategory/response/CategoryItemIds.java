package com.salesmore.yak.integration.shopee.model.shopcategory.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

import java.util.List;

@Data
public class CategoryItemIds implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an item.
     */
    private List<ItemId> items;

    @Data
    public static class ItemId {

        @JsonProperty("item_id")
        private Long itemId;
    }
}
