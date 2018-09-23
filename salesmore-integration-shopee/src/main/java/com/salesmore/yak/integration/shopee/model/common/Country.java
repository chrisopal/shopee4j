package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Country {
    UNRECOGNIZED, MY, TW, SG, PH, TH, ID;

    @JsonCreator
    public static Country value(String v) {
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
