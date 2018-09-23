package com.salesmore.yak.integration.shopee.model.discount.request;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.item.ItemStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class DiscountPaginationRequest extends BaseRequest {

    enum Status {
        UPCOMING, ONGOING, EXPIRED, ALL;

        @JsonCreator
        public static Status forValue(String value) {
            if (value != null) {
                for (Status s : Status.values()) {
                    if (s.name().equals(value))
                        return s;
                }
            }
            return null;
        }

        @JsonValue
        public String value() {
            return name();
        }
    }

    /**
     * Specifies the starting entry of data to return in the current call.
     * Default is 0. if data is more than one page, the offset can be some entry to start next call.
     */
    @JsonProperty("pagination_offset")
    private long paginationOffset;

    /**
     * f many item are available to retrieve, you may need to call GetItemsList multiple times to
     * retrieve all the data. Each result set is returned as a page of entries.
     * Use the Pagination filters to control the maximum number of entries (<= 100) to retrieve per page
     * (i.e., per call), the offset number to start next call.
     * This integer value is usUed to specify the maximum number of entries to return in
     * a single ""page"" of data.
     */
    @JsonProperty("pagination_entries_per_page")
    private long paginationEntriesPerPage;

    /**
     * Shopee's unique identifier for a discount activity.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("discount_id")
    private Long discountId;

    /**
     * The status filter for retriveing discount list. Available value: UPCOMING/ONGOING/EXPIRED/ALL.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("discount_status")
    private Status status;

    /**
     * The update_time_from and update_time_to fields specify a date range for retrieving orders
     * (based on the item update time).
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("update_time_from")
    private long updateTimeFrom;

    /**
     * The update_time_from and update_time_to fields specify a date range for
     * retrieving orders (based on the item update time).
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("update_time_to")
    private long updateTimeTo;


}
