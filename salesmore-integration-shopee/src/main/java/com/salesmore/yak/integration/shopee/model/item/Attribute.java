package com.salesmore.yak.integration.shopee.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.core.service.ListResult;
import com.salesmore.yak.integration.shopee.model.common.AttributeInputType;
import com.salesmore.yak.integration.shopee.model.common.AttributeType;
import lombok.Data;

import java.util.List;


@Data
public class Attribute implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The Identity of each attribute
     */
    @JsonProperty("attribute_id")
    private Long id;

    /**
     * The name of each attribute
     */
    @JsonProperty("attribute_name")
    private String name;

    /**
     * This is to indicate whether this attribute is mandatory
     */
    @JsonProperty("is_mandatory")
    private boolean mandatory;

    /**
     * Enumerated type that defines the type of the attribute.
     * Applicable values: See Data Definition- AttributeType.
     */
    @JsonProperty("attribute_type")
    private AttributeType type;

    /**
     * Enumerated type that defines the input type of the attribute.
     * Applicable values: See Data Definition- AttributeInputType.
     */
    @JsonProperty("input_type")
    private AttributeInputType inputType;

    /**
     * All options that attribute contains, the final attribute value must be one of them
     */
    private List<String> options;


    @Data
    public static class Attributes extends ListResult<Attribute> {

        private static final long serialVersionUID = 1L;

        @JsonProperty("attributes")
        private List<Attribute> attributes;

        @Override
        protected List<Attribute> value() {
            return attributes;
        }
    }

}
