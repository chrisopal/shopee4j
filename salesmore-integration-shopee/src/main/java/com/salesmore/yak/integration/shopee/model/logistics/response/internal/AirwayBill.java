package com.salesmore.yak.integration.shopee.model.logistics.response.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

import java.util.List;

@Data
public class AirwayBill implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an order.
     */
    private String ordersn;

    /**
     * The url of retrieving airway bill.
     */
    @JsonProperty("airway_bill")
    private String airwayBill;

    @Data
    public static class AirwayBills<T> implements ModelEntity {

        public static final long serialVersionUID = 1L;

        @JsonProperty("total_count")
        private Long total_count;

        @JsonProperty("airway_bills")
        private List<T> airwayBills;

        private List<String> errors;
    }
}
