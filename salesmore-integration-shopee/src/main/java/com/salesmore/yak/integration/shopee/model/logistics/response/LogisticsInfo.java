package com.salesmore.yak.integration.shopee.model.logistics.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

import static com.salesmore.yak.integration.shopee.model.logistics.response.Address.Addresses;
import static com.salesmore.yak.integration.shopee.model.logistics.response.Branch.Branches;

@Data
public class LogisticsInfo implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Logistics information for pickup mode order.
     */
    private Addresses pickup;

    /**
     * Logistics information for pickup mode order.
     */
    private Branches dropoff;

    /**
     * The parameters required based on each specific order to Init.
     * Must use the fields included under info_needed to call Init.
     */
    @JsonProperty("info_needed")
    private ParameterForInit infoNeeded;


    /**
     * The identifier for an API request for error tracking
     */
    @JsonProperty("request_id")
    private String requestId;
}
