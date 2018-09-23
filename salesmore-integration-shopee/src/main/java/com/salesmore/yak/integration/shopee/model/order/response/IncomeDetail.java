package com.salesmore.yak.integration.shopee.model.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
public class IncomeDetail implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The three-digit code representing the currency unit used for all transactional amount under
     */
    @JsonProperty("local_currency")
    private String currency;

    /**
     * The total amount paid by the buyer for the order.
     */
    @JsonProperty("total_amount")
    private float totalAmount;

    /**
     * The amount offset when the buyer consumed Shopee Coins upon checkout.
     */
    private float coin;

    /**
     * The amount offset when the buyer used Shopee voucher upon checkout.
     */
    private float voucher;

    /**
     * The amount offset when the buyer used seller-specific voucher upon checkout.
     */
    @JsonProperty("voucher_seller")
    private float voucherSeller;

    /**
     * The platform subsidy to the seller.
     */
    @JsonProperty("seller_rebate")
    private float sellerRebate;

    /**
     * The actual shipping cost of the order if available from external logistics partners.
     */
    @JsonProperty("actual_shipping_cost")
    private float actualShippingCost;

    /**
     * The platform shipping subsidy to the seller.
     */
    @JsonProperty("shipping_fee_rebate")
    private float shippingFeeRebate;

    /**
     * The commission fee charged by Shopee platform if applicable.
     */
    @JsonProperty("commission_fee")
    private float commissionFee;

    /**
     * The voucher code or promotion code the buyer used.
     */
    @JsonProperty("voucher_code")
    private float voucherCode;

    /**
     * The voucher name or promotion name the buyer used.
     */
    @JsonProperty("voucher_name")
    private float voucher_name;

    /**
     * The total amount that the seller is expected to receive for the order.
     */
    @JsonProperty("escrow_amount")
    private float escrowAmount;

    /**
     * The tax buyer paid. It is specific to Taiwan due to local regulations.
     */
    @JsonProperty("cross_border_tax")
    private float crossBorderTax;

    /**
     * The amount offset via credit card promotion.
     */
    @JsonProperty("credit_card_promotion")
    private float creditCardPromotion;

    /**
     * The credit card transaction fee.
     */
    @JsonProperty("credit_card_transaction_fee")
    private float creditCardTransactionFee;


}
