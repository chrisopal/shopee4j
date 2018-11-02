package com.salesmore.yak.integration.shopee.model.logistics.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

import java.util.List;

@Data
public class ParameterForInit implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Could contain 'address_id' and 'pickup_time_id'.
     */
    private List<String> pickup;

    /**
     * Could contain 'branch_id', 'sender_real_name' or 'tracking_no'.
     */
    private List<String> dropoff;

    /**
     * Could contain 'tracking_no'. If it contains 'tracking_no',
     * should manually input these values in Init API.
     */
    @JsonProperty("non_integrated")
    private List<String> nonIntegrated;

    /**
     * The identifier for an API request for error tracking
     */
    @JsonProperty("request_id")
    private String requestId;
}
