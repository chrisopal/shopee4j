package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReturnDisputeReason {


    UNKNOWN(""),
    NON_RECEIPT ("I would like to reject the non-receipt claim"),
    OTHER ("I would like to reject the request"),
    NOT_RECEIVED ("I agree with the return request,but I did not receive the product(s)");
    private String description;

    ReturnDisputeReason(String des){
        this.description = des;
    }

    public String getDescription(){
        return this.description;
    }

    @JsonCreator
    public static ReturnDisputeReason value(String v) {
        if (v == null) return UNKNOWN;
        try {
            return valueOf(v);
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }

    @JsonValue
    public String value() {
        return name();
    }
}
