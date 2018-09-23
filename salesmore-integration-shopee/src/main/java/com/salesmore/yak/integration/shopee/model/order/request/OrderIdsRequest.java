package com.salesmore.yak.integration.shopee.model.order.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.IRequestBase;
import com.salesmore.yak.integration.shopee.model.order.IOrderRequestBase;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class OrderIdsRequest implements IRequestBase {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an order.
     */
    @Singular
    @JsonProperty("ordersn_list")
    private List<String> ordersns;

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

