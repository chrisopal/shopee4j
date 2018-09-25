package com.salesmore.yak.integration.shopee.model.shopcategory.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.core.service.ListResult;
import lombok.Data;

import java.util.List;

@Data
public class CategoryItemId implements ModelEntity {

    public static final long serialVersionUID = 1L;

    @JsonProperty("item_id")
    private Long itemId;



    @Data
    public static class CategoryItemIds extends ListResult<CategoryItemId> {

        /**
         * Shopee's unique identifier for an item.
         */
        @JsonProperty("item")
        private List<CategoryItemId> items;

        @Override
        protected List<CategoryItemId> value() {
            return items;
        }
    }
}
