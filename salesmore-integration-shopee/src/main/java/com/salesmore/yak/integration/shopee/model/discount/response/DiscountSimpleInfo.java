package com.salesmore.yak.integration.shopee.model.discount.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.core.service.ListResult;
import lombok.Data;

import java.util.List;

@Data
public class DiscountSimpleInfo implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a discount activity.
     */
    @JsonProperty("discount_id")
    private Long discountId;

    /**
     * Discount Name
     */
    @JsonProperty("discount_name")
    private String name;

    /**
     * The time when discount activity start.
     */
    @JsonProperty("start_time")
    private Long startTime;

    /**
     * The time when discount activity end. The end time must be 1 hour later than start time.
     */
    @JsonProperty("end_time")
    private Long endTime;

    @Data
    public static class DiscountSimpleInfoList extends ListResult<DiscountSimpleInfo> {

        public static final long serialVersionUID = 1L;

        private boolean more;

        private List<DiscountSimpleInfo> discount;

        /**
         * The identifier for an API request for error tracking
         */
        @JsonProperty("request_id")
        private String requestId;

        @Override
        protected List<DiscountSimpleInfo> value() {
            return discount;
        }

        @Override
        public boolean hasMore() { return more; }

    }
}
