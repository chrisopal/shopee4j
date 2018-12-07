package com.salesmore.yak.integration.fyndiq.model.orders;

import com.google.common.base.MoreObjects;
import com.salesmore.yak.integration.fyndiq.model.common.ActionResponse;

/**
 * Order Create Response
 *
 */
public class OrderCreateResponse implements ActionResponse {

    public static final long serialVersionUID = 1L;

    private String id;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id )
                .add("description", description)
                .toString();
    }
}
