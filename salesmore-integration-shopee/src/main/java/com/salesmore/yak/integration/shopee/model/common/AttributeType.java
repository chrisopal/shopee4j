package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AttributeType {
    UNRECOGNIZED,
    INT_TYPE,
    STRING_TYPE,
    ENUM_TYPE,
    FLOAT_TYPE,
    DATE_TYPE,
    TIMESTAMP_TYPE;

    @JsonCreator
    public static AttributeType value(String v) {
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
