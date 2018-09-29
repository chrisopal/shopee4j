package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.salesmore.yak.integration.core.model.Error;

public enum ResponseError implements Error {

    ERROR_PARAM("error_param", "There are errors in the input parameters"),
    ERROR_PARAMS("error_params", "There are errors in the input parameters"),
    ERROR_AUTH("error_auth", "The request is not authenticated. Ex: signature is wrong"),
    ERROR_SERVER("error_server", "An error has occurred"),
    ERROR_TOO_MANY_REQUEST("error_too_many_request", "Too many request.Exceed 1000 request per min will be banned for an hour"),
    ERROR_NOT_SUPPORT("error_not_support", "Not support action"),
    ERROR_INNER_ERROR("error_inner_error", "An inner error has occurred"),
    ERROR_PERMISSION("error_permission", "Not allowed for this request");

    ResponseError(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String description() {
        return this.description;
    }

    @JsonCreator
    public static ResponseError value(String v)
    {
        for(ResponseError s :ResponseError.values()){
            if(s.code().equalsIgnoreCase(v))
                return s;
        }
        return null;
    }

    @JsonValue
    public String value() {
        return this.code();
    }
}
