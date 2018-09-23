package com.salesmore.yak.integration.shopee.model.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemStatus {
    NORMAL, DELETED, BANNED;

    @JsonCreator
    public static ItemStatus forValue(String value) {
        if (value != null) {
            for (ItemStatus s : ItemStatus.values()) {
                if (s.name().equals(value))
                    return s;
            }
        }
        return null;
    }

    @JsonValue
    public String value() {
        return name();
    }
}
