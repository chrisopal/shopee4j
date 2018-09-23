package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ShopCategoryStatus {

    UNRECOGNIZED, NORMAL, INACTIVE, DELETED;

    @JsonCreator
    public static ShopCategoryStatus value(String v) {
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
