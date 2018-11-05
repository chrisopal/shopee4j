package com.salesmore.yak.integration.shopee.model.logistics.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.common.ListResult;
import com.salesmore.yak.integration.shopee.model.common.FeeType;
import com.salesmore.yak.integration.shopee.model.logistics.response.internal.ItemDimension;
import com.salesmore.yak.integration.shopee.model.logistics.response.internal.Size;
import com.salesmore.yak.integration.shopee.model.logistics.response.internal.WeightLimits;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class Logistics implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The identity of logistic channel
     */
    @JsonProperty("logistic_id")
    private Long id;

    /**
     * The name of logistic channel
     */
    @JsonProperty("logistic_name")
    private String name;

    /**
     * This is to indicate whether this logistic channel supports COD
     */
    @JsonProperty("has_cod")
    private boolean hasCod;

    /**
     * Whether this logistic channel is enabled on shop level.
     */
    @JsonProperty("enabled")
    private boolean enabled;

    /**
     * See Define FeeType, related to FeeType Value
     */
    @JsonProperty("fee_type")
    private FeeType feeType;

    /**
     * Only for fee_type is SIZE_SELECTION
     */
    private List<Size> sizes;

    @JsonProperty("weight_limits")
    private WeightLimits weightLimits;


    @JsonProperty("item_max_dimension")
    private ItemDimension itemMaxDimension;

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class LogisticsList extends ListResult<Logistics> {

        public static final long serialVersionUID = 1L;

        @JsonProperty("logistics")
        private List<Logistics> logisticsList;

        @Override
        protected List<Logistics> value() {
            return logisticsList;
        }
    }
}
