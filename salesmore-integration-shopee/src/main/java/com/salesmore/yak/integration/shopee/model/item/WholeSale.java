package com.salesmore.yak.integration.shopee.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WholeSale implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The min count of this tier wholesale.
     */
    private long min;

    /**
     * The max count of this tier wholesale.
     */
    private long max;

    /**
     * The current price of the wholesale in the listing currency.
     */
    @JsonProperty("unit_price")
    private float unitPrice;
}
