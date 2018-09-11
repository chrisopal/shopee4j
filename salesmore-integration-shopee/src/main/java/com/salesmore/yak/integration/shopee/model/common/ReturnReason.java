package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReturnReason {
    UNRECOGNIZED, NONE, NOT_RECEIPT, WRONG_ITEM, ITEM_DAMAGED, DIFFERENT_DESCRIPTION, MUTUAL_AGREE, OTHER, ITEM_WRONGDAMAGED, CHANGE_MIND, ITEM_MISSING, EXPECTATION_FAILED, ITEM_FAKE;

    @JsonCreator
    public static ReturnReason value(String v) {
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
