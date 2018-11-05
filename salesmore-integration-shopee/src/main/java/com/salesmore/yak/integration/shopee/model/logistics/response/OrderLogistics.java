package com.salesmore.yak.integration.shopee.model.logistics.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import com.salesmore.yak.integration.shopee.model.ObjectResult;
import com.salesmore.yak.integration.shopee.model.order.response.RecipientAddress;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class OrderLogistics implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The logistics service provider that the buyer selected for the order to deliver items.
     */
    @JsonProperty("shipping_carrier")
    private String shippingCarrier;

    /**
     * The identity of logistic channel.
     */
    @JsonProperty("logisticId")
    private String logistic_id;

    /**
     * Only work for cross-border order.
     */
    @JsonProperty("service_code")
    private String serviceCode;

    /**
     * Only work for cross-border order.The name of the carrier ships cross countries.
     */
    @JsonProperty("first_mile_name")
    private String firstMileName;

    /**
     * Only work for cross-border order.The name of the carrier delivers the parcels in local country.
     */
    @JsonProperty("last_mile_name")
    private String lastMileName;

    /**
     * Only work for cross-border order.This value indicates whether the order contains goods that are required to declare at customs.
     */
    @JsonProperty("goods_to_declare")
    private boolean goodsToDeclare;

    /**
     * The tracking number assigned by the shipping carrier for item shipment.
     */
    @JsonProperty("tracking_no")
    private String tracking_no;

    /**
     *
     */
    private String zone;

    /**
     * Only work for cross-border order. The string use for waybill printing. The format is "S - country_code and lane_number".
     * For example, S-TH01, S-TH02
     */
    @JsonProperty("lane_code")
    private String laneCode;

    /**
     * Only work for cross-border order in some special shop.
     */
    @JsonProperty("warehouse_address")
    private String warehouseAddress;

    /**
     * Only work for cross-border order in some special shop. The ID of the warehouse.
     */
    @JsonProperty("warehouse_id")
    private String warehouseId;

    /**
     * This object contains detailed breakdown for the recipient address.
     */
    @JsonProperty("recipient_address")
    private RecipientAddress recipientAddress;

    /**
     * This value indicates whether the order was a COD (cash on delivery) order.
     */
    private boolean code;

    @Data
    public static class OrderLogisticsWrapper extends ObjectResult<OrderLogistics> {

        private static final long serialVersionUID = 1L;

        /**
         * Result Wrapper
         */
        private OrderLogistics logistics;

        @Override
        protected OrderLogistics value() {
            return logistics;
        }
    }
}
