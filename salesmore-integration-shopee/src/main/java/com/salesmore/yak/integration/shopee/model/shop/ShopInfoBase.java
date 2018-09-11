package com.salesmore.yak.integration.shopee.model.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ShopInfoBase implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Name of the shop.
     */
    @JsonProperty("shop_name")
    protected String shopName;

    /**
     * Description of the shop.
     */
    @JsonProperty("shop_description")
    protected String shopDescription;

    /**
     * List of videos URLs of the shop.
     */
    @Singular
    protected List<String> videos;

    /**
     * List of images URLs of the shop.
     */
    @Singular
    protected List<String> images;

    /**
     * Allow negotiations or not, 1: don't allow, 0: allow.
     */
    @JsonProperty("disable_make_offer")
    protected long disableMakeOffer;

    /**
     * Display pickup address or not.
     */
    @JsonProperty("enable_display_unitno")
    protected Boolean enableDisplayUnitno;
}
