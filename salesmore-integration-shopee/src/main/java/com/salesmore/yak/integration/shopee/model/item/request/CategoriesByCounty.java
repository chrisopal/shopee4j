package com.salesmore.yak.integration.shopee.model.item.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.common.Country;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriesByCounty implements ModelEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Two-digit country code.
     */
    private Country country;

    /**
     * Is cross border or not. 1: cross border; 0: not cross border
     */
    @JsonProperty("is_cb")
    private int isCrossBorder;

    /**
     * partner Id field that must be included in all request body
     * This is the assigned to partner upon registration
     */
    @JsonProperty("partner_id")
    protected long partnerId;

    /**
     * timestamp field that must be included in all request body
     *
     * Please put the current UNIX timestamp when making a request
     */
    protected long timestamp;
}
