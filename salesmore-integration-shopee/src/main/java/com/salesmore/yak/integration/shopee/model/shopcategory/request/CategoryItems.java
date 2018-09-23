package com.salesmore.yak.integration.shopee.model.shopcategory.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class CategoryItems extends BaseRequest {

    /**
     * ShopCategory's unique identifier.
     */
    @JsonProperty("shop_category_id")
    private Long shopCategoryId;

    /**
     * ShopCategory's unique identifier.
     */
    private List<Long> items;
}
