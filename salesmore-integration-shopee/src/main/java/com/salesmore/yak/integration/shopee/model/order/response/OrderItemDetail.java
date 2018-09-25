package com.salesmore.yak.integration.shopee.model.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OrderItemDetail extends OrderItemSimple {

	private static final long serialVersionUID = 1L;

    @JsonProperty("item_id")
    private String itemId;

    /**
     * Name of the item in local language.
     */
    @JsonProperty("item_name")
    private String name;

    /**
     * A item SKU (stock keeping unit) is an identifier defined by a seller,
     */
    @JsonProperty("item_sku")
    private String itemSku;

    /**
     * Name of the variation that belongs to the same item.
     */
    @JsonProperty("variation_name")
    private String variationName;

    /**
     * A item SKU (stock keeping unit) is an identifier defined by a seller,
     */
    @JsonProperty("variation_sku")
    private String variationSku;

    /**
     * The offset of this item when the buyer consumed Shopee Coins upon checkout.
     */
    @JsonProperty("discounted_price")
    private float discountedPrice;

    /**
     * The offset of this item when the buyer consumed Shopee Coins upon checkout.
     */
    @JsonProperty("discount_from_coin")
    private float discountFromCoin;

    /**
     * The offset of this item when the buyer use Shopee voucher.
     */
    @JsonProperty("discount_from_voucher")
    private float discountFromVoucher;

    /**
     * The offset of this item when the buyer use seller-specific voucher.
     */
    @JsonProperty("discount_from_voucher_seller")
    private float discountFromVoucherSeller;

    /**
     * Platform subsidy to the seller for this item.
     */
    @JsonProperty("seller_rebate")
    private float sellerRebate;

    /**
     * This value indicates the actual price the buyer pay.
     */
    @JsonProperty("deal_price")
    private float dealPrice;

    /**
     * This value indicate the offset via credit card promotion.
     */
    @JsonProperty("credit_card_promotion")
    private float creditCardPromotion;

    /**
     * TThis value indicates whether buyer buy the order item in wholesale price.
     */
    @JsonProperty("is_wholesale")
    private boolean wholesale;


}
