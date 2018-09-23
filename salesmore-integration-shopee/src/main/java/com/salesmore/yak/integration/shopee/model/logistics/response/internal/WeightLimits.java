package com.salesmore.yak.integration.shopee.model.logistics.response.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

@Data
public class WeightLimits implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The max weight for an item on this logistic channel.
     * If the value is 0 or null, that means there is no limit.
     */
    @JsonProperty("item_max_weight")
    private float itemMaxWeight;

    /**
     * The min weight for an item on this logistic channel.
     * If the value is 0 or null, that means there is no limit.
     */
    @JsonProperty("item_min_weight")
    private float itemMinWeight;
}
