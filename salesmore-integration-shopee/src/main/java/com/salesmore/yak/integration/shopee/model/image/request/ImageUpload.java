package com.salesmore.yak.integration.shopee.model.image.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.IRequestBase;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class ImageUpload implements IRequestBase {

    public static final long serialVersionUID = 1L;

    /**
     * partner Id field that must be included in all request body
     * This is the assigned to partner upon registration
     */
    @JsonProperty("partner_id")
    private long partnerId;

    /**
     * shopid field that must be included in all request body
     * One partner might have multiple associated shopids, please use the correct shopid.
     */
    @JsonProperty("shopid")
    private long shopId;

    /**
     * timestamp field that must be included in all request body
     *
     * Please put the current UNIX timestamp when making a request
     */
    private long timestamp;

    /**
     * Image url. max 2.0 MB each.Image format accepted: JPG, JPEG, PNG.
     * Suggested dimension: 1024 x 1024 px.Max number of image is 9.
     */
    @Singular
    private List<String> images;
}
