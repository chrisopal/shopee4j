package com.salesmore.yak.integration.shopee.model.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Language {

    EN("en"), TH("th"), ID("id"), VI("vi"), ZH_HANT("zh-Hant"), ZH_HANS("zh-Hant"), MS_MY("ms-my");

    private String l;

    Language(String l) {
        this.l = l;
    }

    @JsonValue
    public String getLanguage() {
        return l;
    }

    @JsonCreator
    public static Language forValue(String value) {
        if (value != null) {
            for (Language s : Language.values()) {
                if (s.getLanguage().equals(value))
                    return s;
            }
        }
        return null;
    }
}
