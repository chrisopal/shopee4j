package com.salesmore.yak.integration.shopee.model.item;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Logistic implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * related to shopee.logistics.GetLogistics result.logistics.logistic_id
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("logistic_id")
    private Long id;

    /**
     * Logistic Name
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("logistic_name")
    private String name;

    /**
     * related to shopee.logistics.GetLogistics result.logistics.enabled only affect current item
     */
    private boolean enabled;

    /**
     * Only needed when logistics fee_type = CUSTOM_PRICE.
     */
    @JsonProperty("shipping_fee")
    private float shippingFee;

    /**
     * If specify logistic fee_type is SIZE_SELECTION size_id is required
     */
    @JsonProperty("size_id")
    private Long sizeId;

    /**
     * when seller chooses this option, the shipping fee of this channel
     * on item will be set to 0. Default value is False.
     */
    @JsonProperty("is_free")
    private boolean free;

    /**
     * Estimated shipping fee calculated by weight. Don't exist if channel is no-integrated.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("estimated_shipping_fee")
    private float estimatedShippingFee;
}
