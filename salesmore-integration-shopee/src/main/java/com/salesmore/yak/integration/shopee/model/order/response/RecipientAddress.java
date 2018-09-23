package com.salesmore.yak.integration.shopee.model.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.AddressBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecipientAddress extends AddressBase {

    public static final long serialVersionUID = 1L;

    /**
     * Recipient's phone number input when order was placed.
     */
    private String phone;

    @JsonProperty("full_address")
    private String fullAddress;


}
