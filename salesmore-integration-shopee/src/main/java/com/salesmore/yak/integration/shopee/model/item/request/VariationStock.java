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

	private static final long serialVersionUID = 1L;
    /**
     * Specify the updated stock quantity.
     */
    private Long stock;
}


