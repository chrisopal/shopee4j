package com.salesmore.yak.integration.shopee.model.order.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.order.IOrderRequestBase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderIdRequest implements IOrderRequestBase {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an order.
     */
    private String ordersn;

    /**
     * partner Id field that must be included in all request body
     * This is the assigned to partner upon registration
     */
    @JsonProperty("partner_id")
    private long partnerId;

    /**
     * shopid field that must be included in all request body
     * One partner might have multiple associated shopids, please use the correct shopid.
     */
    @JsonProperty("shopid")
    private long shopId;

    /**
     * timestamp field that must be included in all request body
     *
     * Please put the current UNIX timestamp when making a request
     */
    private long timestamp;
}
