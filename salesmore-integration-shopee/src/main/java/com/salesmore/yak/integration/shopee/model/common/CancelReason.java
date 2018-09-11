package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CancelReason {
    UNRECOGNIZED,
    OUT_OF_STOCK,
    CUSTOMER_REQUEST,
    UNDELIVERABLE_AREA,
    COD_NOT_SUPPORTED;

    @JsonCreator
    public static CancelReason value(String v) {
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
