package com.salesmore.yak.integration.shopee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.Error;
import com.salesmore.yak.integration.core.model.ErrorBaseResponse;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.common.ResponseError;
import lombok.Data;

@Data
public class ErrorResponse implements ErrorBaseResponse, ModelEntity {

    public static final long serialVersionUID = 1L;

    private String msg;

    private ResponseError error;

    /**
     * The identifier for an API request for error tracking which is used by every request
     */
    @JsonProperty("request_id")
    private String requestId;

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Error getError() {
        return error;
    }
}
