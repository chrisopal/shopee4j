package com.salesmore.yak.integration.shopee.model.logistics.request.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pickup implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The identity of address. Retrieved from shopee.logistics.GetAddress.
     */
    @JsonProperty("address_id")
    private Long addressId;

    /**
     * The pickup time id. Retrieved from shopee.logistics.GetTimeSlot.
     */
    @JsonProperty("pickup_time_id")
    private String pickupTimeId;

    /**
     * The tracking number assigned by the shipping carrier for item shipment.
     */
    @JsonProperty("tracking_no")
    private String trackingNo;
}
