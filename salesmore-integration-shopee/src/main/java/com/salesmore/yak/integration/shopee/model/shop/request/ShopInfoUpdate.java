package com.salesmore.yak.integration.shopee.model.shop.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.IRequestBase;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class ShopInfoUpdate extends BaseRequest {

    
    /**
     * Name of the shop.
     */
    @JsonProperty("shop_name")
    private String shopName;

    /**
     * Description of the shop.
     */
    @JsonProperty("shop_description")
    private String shopDescription;

    /**
     * List of videos URLs of the shop.
     */
    @Singular
    private List<String> videos;

    /**
     * List of images URLs of the shop.
     */
    @Singular
    private List<String> images;

    /**
     * Allow negotiations or not, 1: don't allow, 0: allow.
     */
    @JsonProperty("disable_make_offer")
    private long disableMakeOffer;

    /**
     * Display pickup address or not.
     */
    @JsonProperty("enable_display_unitno")
    private Boolean enableDisplayUnitno;

}
