package com.salesmore.yak.integration.shopee.model.shop.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.Error;
import com.salesmore.yak.integration.core.model.ErrorBaseResponse;
import com.salesmore.yak.integration.shopee.model.common.Country;
import com.salesmore.yak.integration.shopee.model.common.ResponseError;
import com.salesmore.yak.integration.shopee.model.shop.ShopInfoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopInfoUpdatedResult extends ShopInfoBase {

	private static final long serialVersionUID = 1L;
	
    private String msg;

    private ResponseError error;

    /**
     * Shopee's unique identifier for a shop.
     */
    @JsonProperty("shopid")
    private long shopId;

    /**
     * Warning message if parts of image/video uploads failed.
     */
    private String warning;

    /**
     * The two-digit code representing the country where the order was made.
     */
    private Country country;

}
