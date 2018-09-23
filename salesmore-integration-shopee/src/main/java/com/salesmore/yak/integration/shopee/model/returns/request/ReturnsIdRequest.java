package com.salesmore.yak.integration.shopee.model.returns.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.returns.IReturnsRequestBase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReturnsIdRequest implements IReturnsRequestBase {

    public static final long serialVersionUID = 1L;

    /**
     * The serial number of return.
     */
    private String returnsn;

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
