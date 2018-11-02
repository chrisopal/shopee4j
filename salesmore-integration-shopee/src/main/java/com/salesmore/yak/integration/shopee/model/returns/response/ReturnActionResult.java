package com.salesmore.yak.integration.shopee.model.returns.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;


@Data
public class ReturnActionResult extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;


    /**
     * The serial number of return.
     */
    private String returnsn;

    /**
     * Action Result Message
     */
    private String msg;

    /**
     * The identifier for an API request for error tracking
     */
    @JsonProperty("request_id")
    private String requestId;
}
