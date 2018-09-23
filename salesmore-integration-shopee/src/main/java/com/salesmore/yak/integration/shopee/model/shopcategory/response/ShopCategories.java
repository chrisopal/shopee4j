package com.salesmore.yak.integration.shopee.model.shopcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.shopcategory.ShopCategory;
import lombok.Data;

import java.util.List;

@Data
public class ShopCategories implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Returned shop category list
     */
    @JsonProperty("shop_categorys")
    private List<ShopCategory> shopCategories;

    /**
     * This is to indicate whether the shop categorys list is more than one page.
     * If this value is true, you may want to continue to check next page to
     * retrieve the rest of shop categorys.
     */
    private boolean more;
}
