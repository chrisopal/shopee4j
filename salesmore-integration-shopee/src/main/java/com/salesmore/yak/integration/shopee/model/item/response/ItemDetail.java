package com.salesmore.yak.integration.shopee.model.item.response;

import com.salesmore.yak.integration.shopee.model.ObjectResult;
import lombok.Data;

@Data
public class ItemDetail extends ObjectResult<ItemInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * Detailed Item info
     */
    private ItemInfo item;

    @Override
    protected ItemInfo value() {
        return item;
    }
}
