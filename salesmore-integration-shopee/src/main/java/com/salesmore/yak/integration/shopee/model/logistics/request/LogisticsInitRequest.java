package com.salesmore.yak.integration.shopee.model.logistics.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.logistics.request.internal.Dropoff;
import com.salesmore.yak.integration.shopee.model.logistics.request.internal.NonIntegrated;
import com.salesmore.yak.integration.shopee.model.logistics.request.internal.Pickup;
import com.salesmore.yak.integration.shopee.model.order.IOrderRequestBase;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LogisticsInitRequest implements IOrderRequestBase {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an order.
     */
    private String ordersn;

    /**
     * Required parameter ONLY if GetParameterForInit returns "pickup"
     * or if GetLogisticsInfo returns "pickup" under "info_needed" for the same order.
     */
    private Pickup pickup;

    /**
     * Required parameter ONLY if GetParameterForInit returns "dropoff"
     * or if GetLogisticsInfo returns "dropoff" under "info_needed" for the same order.
     */
    private Dropoff dropoff;

    /**
     * Required parameter ONLY if GetParameterForInit returns "non-integrated"
     * or if GetLogisticsInfo returns "non-integrated" under "info_needed" for the same order.
     */
    @JsonProperty("non_integrated")
    private NonIntegrated nonIntegrated;

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
