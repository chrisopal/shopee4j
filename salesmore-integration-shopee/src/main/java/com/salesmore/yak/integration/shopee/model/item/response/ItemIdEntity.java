package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.ModelIdEntity;
import lombok.Data;

@Data
public class ItemIdEntity implements ModelIdEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Item Id
     */
    @JsonProperty("item_id")
    private Long id;

    /**
     * messages for Delete
     */
    private String msg;



}
