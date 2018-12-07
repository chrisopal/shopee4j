package com.salesmore.yak.integration.fyndiq.model.articles;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * Supported Markets, Mapping to java.util.Locale.getCountry().
 *
 * So far it's only supported below markets, it can be extended or directly mapping to string.
 *
 */
public enum Market {
    UNRECOGNIZED, DE, SE, UK;

    @JsonCreator
    public static Market value(String v)
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
        return name();
    }
}

