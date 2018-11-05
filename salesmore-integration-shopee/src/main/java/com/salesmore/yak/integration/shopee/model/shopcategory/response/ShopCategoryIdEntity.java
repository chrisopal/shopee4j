package com.salesmore.yak.integration.shopee.model.shopcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import com.salesmore.yak.integration.shopee.model.ModelIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ShopCategoryIdEntity extends ErrorResponse implements ModelIdEntity {

    public static final long serialVersionUID = 1L;

    /**
     * ShopCategory's unique identifier.
     */
    @JsonProperty("shop_category_id")
    private Long id;

    /**
     * Result Message
     */
    //private String msg;

}
