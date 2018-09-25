package com.salesmore.yak.integration.shopee.model.logistics.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.service.ListResult;
import com.salesmore.yak.integration.shopee.model.AddressBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Address extends AddressBase {

	
	private static final long serialVersionUID = 1L;
    /**
     * The identity of address
     */
    @JsonProperty("address_id")
    private Long id;

    /**
     * List of pickup_time information corresponding to the address_id.
     * Used in Logistics Info
     */
    @JsonProperty("time_slot_list")
    private List<PickupTime> timeSlotList;

    @Data
    public static class Addresses extends ListResult<Address> {

        public static final long serialVersionUID = 1L;

        @JsonProperty("address_list")
        private List<Address> addresses;

        @Override
        protected List<Address> value() {
            return addresses;
        }
    }
}
