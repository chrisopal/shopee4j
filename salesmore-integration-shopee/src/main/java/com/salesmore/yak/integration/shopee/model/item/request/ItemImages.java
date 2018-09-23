package com.salesmore.yak.integration.shopee.model.item.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.IIdRequestBase;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;


@Data
@Builder
public class ItemImages implements IIdRequestBase {

    public static final long serialVersionUID = 1L;

    /**
     * Unique identifier for an item.
     */
    @JsonProperty("item_id")
    private Long id;

    /**
     * Image Urls
     */
    @Singular
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<String> images;

    /**
     * Image Positions
     */
    @Singular
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<Integer> positions;

    /**
     * partner Id field that must be included in all request body
     * This is the assigned to partner upon registration
     */
    @JsonProperty("partner_id")
    protected long partnerId;

    /**
     * shopid field that must be included in all request body
     * One partner might have multiple associated shopids, please use the correct shopid.
     */
    @JsonProperty("shopid")
    protected long shopId;

    /**
     * timestamp field that must be included in all request body
     *
     * Please put the current UNIX timestamp when making a request
     */
    protected long timestamp;
}
