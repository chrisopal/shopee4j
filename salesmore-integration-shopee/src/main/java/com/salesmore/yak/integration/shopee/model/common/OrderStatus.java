package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {

    UNRECOGNIZED, UNPAID, READY_TO_SHIP, RETRY_SHIP, SHIPPED, TO_CONFIRM_RECEIVE, IN_CANCEL, CANCELLED, TO_RETURN, COMPLETED;

    @JsonCreator
    public static OrderStatus value(String v) {
        if (v == null) return UNRECOGNIZED;
        try {
            return valueOf(v.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNRECOGNIZED;
        }
    }

    @JsonValue
    public String value() {
        return name().toUpperCase();
    }
}
