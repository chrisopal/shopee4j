package com.salesmore.yak.integration.shopee.model.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.common.Country;
import com.salesmore.yak.integration.shopee.model.common.OrderStatus;
import com.salesmore.yak.integration.shopee.model.common.PaymentMethod;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetail  implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for an order.
     */
    private String ordersn;

    /**
     * The two-digit code representing the country where the order was made.
     */
    private Country country;

    /**
     * The three-digit code representing the currency unit for which the order was paid.
     */
    private String currency;

    /**
     * This value indicates whether the order was a COD (cash on delivery) order.
     */
    private boolean cod;

    /**
     * The tracking number assigned by the shipping carrier for item shipment.
     */
    @JsonProperty("tracking_no")
    private String trackingNo;

    /**
     * Shipping preparation time set by the seller when listing item on Shopee.
     */
    @JsonProperty("days_to_ship")
    private Long daysToShip;

    /**
     * This object contains detailed breakdown for the recipient address.
     */
    @JsonProperty("recipient_address")
    private RecipientAddress recipientAddress;

    /**
     * The estimated shipping fee paid by buyer when placing order with selected logistics service provider.
     */
    @JsonProperty("estimated_shipping_fee")
    private float estimatedShippingFee;

    /**
     * The actual shipping cost of the order if available from external logistics partners.
     */
    @JsonProperty("actual_shipping_cost")
    private float actualShippingCost;

    /**
     * The total amount paid by the buyer for the order. This amount includes the total sale price of items, shipping cost beared by buyer;
     * and offset by Shopee promotions if applicable.
     * This value will only return after the buyer has completed payment for the order.
     */
    @JsonProperty("total_amount")
    private float totalAmount;

    /**
     * The total amount that the seller is expected to receive for the order.
     */
    @JsonProperty("escrow_amount")
    private float escrowAmount;

    /**
     * Enumerated type that defines the current status of the order.
     */
    @JsonProperty("order_status")
    private OrderStatus status;

    /**
     * The logistics service provider that the buyer selected for the order to deliver items.
     */
    @JsonProperty("shippingCarrier")
    private String shipping_carrier;

    /**
     * The payment method that the buyer selected to pay for the order.
     */
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    /**
     * Only work for cross-border order.This value indicates whether
     * the order contains goods that are required to declare at customs.
     */
    @JsonProperty("goods_to_declare")
    private boolean goodsToDeclare;

    /**
     * Message to seller.
     */
    @JsonProperty("message_to_seller")
    private String messageToSeller;

    /**
     * The note seller made for own reference.
     */
    private String note;

    /**
     * Update time for the note.
     */
    @JsonProperty("note_update_time")
    private String noteUpdateTime;

    /**
     * The time when discount activity start.
     */
    @JsonProperty("create_time")
    private Long createTime;

    /**
     * The time when discount activity end. The end time must be 1 hour later than start time.
     */
    @JsonProperty("update_time")
    private Long updateTime;

    /**
     * This object contains the detailed breakdown for all the items in this order,
     * including regular items(non-activity) and activity items.
     */
    private List<OrderItemDetail> items;

    @JsonProperty("pay_time")
    private Long payTime;

}
