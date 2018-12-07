package com.salesmore.yak.integration.fyndiq.model.articles;

import com.google.common.base.MoreObjects;
import com.salesmore.yak.integration.core.model.ModelEntity;

public class PropertyPair implements ModelEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("name", name)
                .add("value", value)
                .toString();
    }
}
