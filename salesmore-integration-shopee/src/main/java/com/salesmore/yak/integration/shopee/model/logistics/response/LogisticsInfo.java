package com.salesmore.yak.integration.shopee.model.logistics.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static com.salesmore.yak.integration.shopee.model.logistics.response.Address.Addresses;
import static com.salesmore.yak.integration.shopee.model.logistics.response.Branch.Branches;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class LogisticsInfo extends ErrorResponse implements ModelEntity {

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
}
