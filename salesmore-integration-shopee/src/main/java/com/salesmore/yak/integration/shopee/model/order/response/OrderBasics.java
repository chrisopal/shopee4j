package com.salesmore.yak.integration.shopee.model.order.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.core.service.ListResult;
import com.salesmore.yak.integration.shopee.model.common.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderBasics implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an order.
     */
    private String ordersn;

    /**
     * Enumerated type that defines the current status of the order.
     */
    @JsonProperty("order_status")
    private OrderStatus status;

    /**
     * Update time for the note.
     */
    @JsonProperty("update_time")
    private String updateTime;

    @Data
    public static class OrderBasicsList extends ListResult<OrderBasics> {

        public static final long serialVersionUID = 1L;

        private List<OrderBasics> orders;

        private boolean more;

        /**
         * The identifier for an API request for error tracking
         */
        @JsonProperty("request_id")
        private String requestId;

        @Override
        protected List<OrderBasics> value() {
            return orders;
        }

        @Override
        public boolean hasMore() {
            return more;
        }
    }


}
