package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ItemImagesResult extends ErrorResponse implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Unique identifier for an item.
     */
    @JsonProperty("item_id")
    private Long itemId;

    /**
     * Image URLs for fail download.
     */
    @JsonProperty("fail_image")
    private List<String> failImage;

    /**
     * Image URLs of item.
     */
    private List<String> images;

    /**
     * The time when the image is inserted.
     */
    @JsonProperty("modified_time")
    private Long modifiedTime;
}
