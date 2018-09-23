package com.salesmore.yak.integration.shopee.model.discount.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.IIdRequestBase;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DiscountIdRequest implements IIdRequestBase {


    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a discount activity.
     */
    @JsonProperty("discount_id")
    private Long id;

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
