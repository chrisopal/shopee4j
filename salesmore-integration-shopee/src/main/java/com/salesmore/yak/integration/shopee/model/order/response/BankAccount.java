package com.salesmore.yak.integration.shopee.model.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

@Data
public class BankAccount implements ModelEntity {

    public static final long serialVersionUID = 1L;

    @JsonProperty("bank_name")
    private String name;

    @JsonProperty("bank_account_number")
    private String accountNumber;

    @JsonProperty("bank_account_country")
    private String bankCountry;
}
