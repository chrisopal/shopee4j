package com.salesmore.yak.integration.fyndiq.model.articles;


import com.google.common.base.MoreObjects;
import com.salesmore.yak.integration.core.model.ModelEntity;

/**
 * Language Model
 *
 */
public class Language implements ModelEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private String language;
    private String value;

    public Language() {}

    public Language(String language, String value) {
        this.language = language;
        this.value = value;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("language", language)
                .add("value", value)
                .toString();
    }
}
