package com.salesmore.yak.integration.shopee.model.discount.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiscountItems extends BaseRequest {

    /**
     * Shopee's unique identifier for a discount activity.
     */
    @JsonProperty("discount_id")
    private Long discountId;

    /**
     * All Items
     */
    @Singular
    private List<DiscountItem> items;
}
