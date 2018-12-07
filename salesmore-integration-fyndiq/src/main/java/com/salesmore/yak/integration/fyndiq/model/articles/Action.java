package com.salesmore.yak.integration.fyndiq.model.articles;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * Supported Actions in Bulk Operation
 *
 *
 */
public enum Action {
    UNRECOGNIZED, UPDATE_ARTICLE, UPDATE_ARTICLE_PRICE, UPDATE_ARTICLE_QUANTITY, DELETE_ARTICLE;

    @JsonCreator
    public static Action value(String v)
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

