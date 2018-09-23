package com.salesmore.yak.integration.shopee.model.logistics.response.internal;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

@Data
public class Size implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The identity of size.
     */
    @JsonProperty("size_id")
    private Long id;

    /**
     * The name of size.
     */
    private String name;

    /**
     * The pre-defined shipping fee for the specific size.
     */
    @JsonProperty("default_price")
    private Long defaultPrice;

}
