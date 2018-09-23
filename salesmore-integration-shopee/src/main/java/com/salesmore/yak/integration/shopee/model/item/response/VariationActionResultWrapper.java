package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.ToString;


@Data
public class VariationActionResultWrapper implements ModelEntity {

    public static final long serialVersionUID = 1L;
    /**
     * Result
     */
    @JsonProperty("item")
    private VariationActionResult item;

}
