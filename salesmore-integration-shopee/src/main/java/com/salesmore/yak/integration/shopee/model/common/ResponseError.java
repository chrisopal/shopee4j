package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseError {

    UNRECOGNIZED("", ""),
    ERROR_PARAMS("error_params", "There are errors in the input parameters"),
    ERROR_AUTH("error_auth", "The request is not authenticated. Ex: signature is wrong"),
    ERROR_SERVER("error_server", "An error has occurred"),
    ERROR_TOO_MANY_REQUEST("error_too_many_request", "Too many request.Exceed 1000 request per min will be banned for an hour"),
    ERROR_NOT_SUPPORT("error_not_support", "Not support action"),
    ERROR_INNER_ERROR("error_inner_error", "An inner error has occurred");

    ResponseError(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;

    public String code() {
        return this.code;
    }


    public String description() {
        return this.description;
    }

    @JsonCreator
    public static ResponseError value(String v)
    {
        for(ResponseError s :ResponseError.values()){
            if(s.code().equals(v))
                return s;
        }
        return UNRECOGNIZED;
    }

    @JsonValue
    public String value() {
        return this.code();
    }
}
