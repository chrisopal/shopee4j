package com.salesmore.yak.integration.shopee.model.logistics.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.common.ListResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class PickupTime implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The identity of pickuptime.
     */
    @JsonProperty("pickup_time_id")
    private String pickupTimeId;

    /**
     * The date of pickup time. In timestamp.
     */
    private Long date;

    /**
     * The text description of pickup time. Currently only Indonesia Poslaju channel returns this field.
     */
    @JsonProperty("time_text")
    private String timeText;

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class  PickupTimeSlots extends ListResult<PickupTime> {

        public static final long serialVersionUID = 1L;

        @JsonProperty("pickup_time")
        private List<PickupTime> pickupTimes;

        @Override
        protected List<PickupTime> value() {
            return pickupTimes;
        }
    }
}
