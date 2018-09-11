package com.salesmore.yak.integration.shopee.model.shop.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.common.Country;
import com.salesmore.yak.integration.shopee.model.shop.ShopInfoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ShopInfo extends ShopInfoBase {

    public static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a shop.
     */
    @JsonProperty("shop_id")
    private long shopId;

    /**
     * The two-digit code representing the country where the order was made.
     */
    private Country country;

    /**
     * Listing limitation of items for the shop.
     */
    @JsonProperty("item_limit")
    private long itemLimit;
}
