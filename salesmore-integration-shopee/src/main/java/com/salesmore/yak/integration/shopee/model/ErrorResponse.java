package com.salesmore.yak.integration.shopee.model;

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

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Error getError() {
        return error;
    }
}
