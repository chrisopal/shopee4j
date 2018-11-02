package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.service.ListResult;
import lombok.Data;

import java.util.List;

@Data
public class ItemsResult extends ListResult<ItemSimpleInfo> {

    public static final long serialVersionUID = 1L;

    /**
     * Item Lists
     */
    @JsonProperty("items")
    List<ItemSimpleInfo> items;

    /**
     * The identifier for an API request for error tracking
     */
    @JsonProperty("request_id")
    private String requestId;

    /**
     * This is to indicate whether the item list is more than one page.
     * If this value is true, you may want to continue to check next page to retrieve the rest of items.
     */
    private boolean more;

    @Override
    protected List<ItemSimpleInfo> value() {
        return items;
    }

    @Override
    public boolean hasMore() {
        return more;
    }
}
