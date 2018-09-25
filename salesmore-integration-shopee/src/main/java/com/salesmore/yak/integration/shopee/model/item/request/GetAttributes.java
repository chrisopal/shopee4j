package com.salesmore.yak.integration.shopee.model.item.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.common.Country;
import com.salesmore.yak.integration.shopee.model.item.Language;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class GetAttributes extends BaseRequest {
	
	private static final long serialVersionUID = 1L;



    /**
     * The Identify of category. Should call shopee.item.GetCategories to get category_id first.
     * Attributes can ONLY be fetched for the category_id WITHOUT children.
     */
    @JsonProperty("category_id")
    private Long categoryId;

    /**
     * This value indicate the language of the attribute_name and options. Applicable values: en (for English), th (for Thai).
     * And if there is no information in this language, we will return the default information.
     * Now this param is only valid for Thailand sellers.
     */
    private Language language;

    /**
     * Two-digit country code.
     */
    private Country country;

    /**
     * Is cross-border or not. Should be provided if no "shopid".
     */
    @JsonProperty("is_cb")
    private boolean cb;

}
