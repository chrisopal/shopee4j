package com.salesmore.yak.integration.fyndiq.model.orders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * Order State
 *
 *
 */
public enum State {
    UNRECOGNIZED, HANDLED, SHIPPED, CANCELLED, REFUNDED, FULFILLED, NOT_FULFILLED;

    @JsonCreator
    public static State value(String v)
    {
        if (v == null) return UNRECOGNIZED;
        try {
            return valueOf(v.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNRECOGNIZED;
        }
    }

    @JsonValue
    public String value() {
        return name().toLowerCase();
    }
}

