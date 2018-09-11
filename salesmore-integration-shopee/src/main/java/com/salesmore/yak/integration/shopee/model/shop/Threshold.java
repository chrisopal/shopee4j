package com.salesmore.yak.integration.shopee.model.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.common.ThresholdType;
import lombok.Data;

@Data
public class Threshold {

    /**
     * Threshold Type String
     *
     * The threshold used to compare shop's actual performance to the target performance.
     */
    @JsonProperty("threshold_type")
    private ThresholdType thresholdType;
    /**
     * Threshold Unit String
     *
     * The unit of the performance index.
     */
    private String unit;
    /**
     * Threshold Target int
     *
     * Your target performance index.
     */
    private int target;
    /**
     * Threshold Actual index float
     *
     * Your actual performance index.
     */
    private float my;
}
