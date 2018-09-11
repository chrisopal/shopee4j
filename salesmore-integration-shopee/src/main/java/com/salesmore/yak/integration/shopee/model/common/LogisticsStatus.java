package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LogisticsStatus {

    NOT_START,
    REQUEST_CREATED,
    PICKUP_DONE,
    PICKUP_RETRY,
    PICKUP_FAILED,
    DELIVERY_DONE,
    DELIVERY_FAILED,
    REQUEST_CANCELED,
    COD_REJECTED,
    READY,
    INVALID,
    LOST,
    UNKNOWN;

    @JsonCreator
    public static LogisticsStatus value(String v) {
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
