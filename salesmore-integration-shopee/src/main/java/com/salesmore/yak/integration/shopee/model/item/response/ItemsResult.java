package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.common.ListResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ItemsResult extends ListResult<ItemSimpleInfo> {

    public static final long serialVersionUID = 1L;

    /**
     * Item Lists
     */
    @JsonProperty("items")
    List<ItemSimpleInfo> items;

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
