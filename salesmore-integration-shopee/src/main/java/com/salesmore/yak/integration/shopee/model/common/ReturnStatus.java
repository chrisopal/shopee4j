package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReturnStatus {
    UNRECOGNIZED, REQUESTED, ACCEPTED, CANCELLED, JUDGING, REFUND_PAID, CLOSED, PROCESSING, SELLER_DISPUTE;

    @JsonCreator
    public static ReturnStatus value(String v) {
        if (v == null) return UNRECOGNIZED;
        try {
            return valueOf(v);
        } catch (IllegalArgumentException e) {
            return UNRECOGNIZED;
        }
    }

    @JsonValue
    public String value() {
        return name();
    }
}
