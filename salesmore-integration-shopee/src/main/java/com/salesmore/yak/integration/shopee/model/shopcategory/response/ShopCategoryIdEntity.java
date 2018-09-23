package com.salesmore.yak.integration.shopee.model.shopcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.ModelIdEntity;
import lombok.Data;

@Data
public class ShopCategoryIdEntity implements ModelIdEntity {

    public static final long serialVersionUID = 1L;

    /**
     * ShopCategory's unique identifier.
     */
    @JsonProperty("shop_category_id")
    private Long id;

    /**
     * Result Message
     */
    private String msg;

}
