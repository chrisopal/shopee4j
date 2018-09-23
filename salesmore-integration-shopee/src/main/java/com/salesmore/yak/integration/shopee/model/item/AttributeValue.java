package com.salesmore.yak.integration.shopee.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttributeValue implements ModelEntity {

    private static final long serialVersionUID = 1L;

    /**
     * related to shopee.item.GetAttributes result.attributes.attribute_id
     */
    @JsonProperty("attributes_id")
    private Long attributeId;

    /**
     * related to shopee.item.GetAttributes one of result.attributes.options
     */
    private String value;
}
