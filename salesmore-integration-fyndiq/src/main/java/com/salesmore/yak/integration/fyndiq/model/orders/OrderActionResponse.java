package com.salesmore.yak.integration.fyndiq.model.orders;

import com.salesmore.yak.integration.fyndiq.model.common.ActionResponse;

public class OrderActionResponse implements ActionResponse {

    private static final long serialVersionUID = 1L;

    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
