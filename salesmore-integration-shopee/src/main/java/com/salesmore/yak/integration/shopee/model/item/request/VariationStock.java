package com.salesmore.yak.integration.shopee.model.item.request;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VariationStock extends VariationIdRequest {

    /**
     * Specify the updated stock quantity.
     */
    private Long stock;
}


