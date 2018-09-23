package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;


@Data
public class ItemActionResultWrapper implements ModelEntity {

    public static final long serialVersionUID = 1L;
    /**
     * Result
     */
    @JsonProperty("item")
    private ItemUpdateActionResult item;

}
