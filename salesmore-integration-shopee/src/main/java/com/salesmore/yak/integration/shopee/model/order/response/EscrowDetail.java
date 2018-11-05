package com.salesmore.yak.integration.shopee.model.order.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import com.salesmore.yak.integration.shopee.model.common.Country;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class EscrowDetail extends ErrorResponse implements ModelEntity {

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
     * This object contains detailed income breakdown for the order.
     */
    @JsonProperty("income_details")
    private IncomeDetail incomeDetails;

    /**
     * The logistics service provider that the buyer selected for the order to deliver items.
     */
    @JsonProperty("shipping_carrier")
    private String shippingCarrier;

    /**
     * The three-digit code representing the currency unit of total
     * order amount (escorw_amount) at the point of payment to the seller.
     */
    @JsonProperty("escrow_currency")
    private String escrowCurrency;

    /**
     * The exchange rate used by Shopee to convert local_currency to escrow_currency.
     */
    @JsonProperty("exchange_rate")
    private String  exchangeRate;

    /**
     * The payment channel that the seller selected to receive escrow for the order.
     */
    @JsonProperty("escrow_channel")
    private String escrowChannel;

    /**
     * The unique identifier for a payee by the 3rd party payment service provider selected in escrow_channel.
     */
    @JsonProperty("payee_id")
    private String payeeId;

    /**
     * This object contains detailed breakdown for bank account of the seller
     * if selected escorw_channel is Bank Transfer.
     */
    @JsonProperty("bank_account")
    private BankAccount bankAccount;

    /**
     * This object contains the detailed breakdown for all the items in this order,
     * including regular items(non-activity) and activity items.
     */
    private List<OrderItemDetail> items;

    /**
     * This object contains the activity in this order.
     */
    @JsonProperty("activity")
    List<Activity> activities;
}
