package com.salesmore.yak.integration.shopee.model.logistics.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.order.IOrderRequestBase;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LogisticsIdRequest implements IOrderRequestBase {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an order.
     */
    private String ordersn;

    /**
     * The identify of address.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("address_id")
    private Long addressId;

    /**
     * The tracking number assigned by the shipping carrier for item shipment.
     * If there are more than one tracking number in one order, this param is necessary.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tracking_number")
    private String trackingNumber;

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
