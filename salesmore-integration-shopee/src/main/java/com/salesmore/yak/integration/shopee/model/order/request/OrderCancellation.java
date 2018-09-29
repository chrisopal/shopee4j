package com.salesmore.yak.integration.shopee.model.order.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.salesmore.yak.integration.shopee.model.item.ItemStatus;
import com.salesmore.yak.integration.shopee.model.order.IOrderRequestBase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCancellation implements IOrderRequestBase {

    public static final long serialVersionUID = 1L;

    public enum CancelReason {
        OUT_OF_STOCK, CUSTOMER_REQUEST, UNDELIVERABLE_AREA, COD_NOT_SUPPORTED;

        @JsonCreator
        public static CancelReason forValue(String value) {
            if (value != null) {
                for (CancelReason s : CancelReason.values()) {
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
     * Shopee's unique identifier for an order.
     */
    private String ordersn;

    /**
     * The note seller made for own reference.
     */
    @JsonProperty("cancel_reason")
    private CancelReason cancelReason;

    /**
     * Shopee's unique identifier for a discount item.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("Item_id")
    private Long itemId;

    /**
     * Shopee's unique identifier for a variation of an item.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("variation_id")
    private Long variationId;

    /**
     * partner Id field that must be included in all request body
     * This is the assigned to partner upon registration
     */
    @JsonProperty("partner_id")
    private long partnerId;

    /**
     * shopid field that must be included in all request body
     * One partner might have multiple associated shopids, please use the correct shopid.
     */
    @JsonProperty("shopid")
    private long shopId;

    /**
     * timestamp field that must be included in all request body
     *
     * Please put the current UNIX timestamp when making a request
     */
    private long timestamp;
}
