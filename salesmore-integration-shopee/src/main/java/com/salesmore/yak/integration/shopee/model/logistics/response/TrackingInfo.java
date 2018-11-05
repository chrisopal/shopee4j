package com.salesmore.yak.integration.shopee.model.logistics.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import com.salesmore.yak.integration.shopee.model.common.TrackingLogisticsStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class TrackingInfo implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The time when logistics info has been updated.
     */
    private Long ctime;

    /**
     * The order logistics tracking info.
     */
    private String description;

    /**
     * The order logistics status.
     */
    private TrackingLogisticsStatus status;

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class TrackingInfoResult extends ErrorResponse implements ModelEntity {

        public static final long serialVersionUID = 1L;

        /**
         *
         */
        @JsonProperty("tracking_info")
        private List<TrackingInfo> trackingInfoList;

        /**
         * The tracking number assigned by the shipping carrier for item shipment.
         */
        @JsonProperty("tracking_number")
        private String trackingNumber;
    }
}
