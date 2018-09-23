package com.salesmore.yak.integration.shopee.model.returns.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.common.ReturnDisputeReason;
import com.salesmore.yak.integration.shopee.model.returns.IReturnsRequestBase;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReturnDisputeRequest implements IReturnsRequestBase {

    public static final long serialVersionUID = 1L;

    /**
     * The serial number of return.
     */
    private String returnsn;

    /**
     * Seller's email.
     */
    private String email;

    /**
     * The reason for seller dispute the return.
     */
    @JsonProperty("dispute_reason")
    private ReturnDisputeReason  disputeReason;

    /**
     * The reason description for seller dispute the return.
     */
    @JsonProperty("dispute_text_reason")
    private String disputeTextReason;

    /**
     * Image URLs that seller provide. Seller can upload up 3 images at most.
     */
    private List<String> images;

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
