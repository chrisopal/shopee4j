package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import com.salesmore.yak.integration.shopee.model.item.Image;
import lombok.Data;

import java.util.List;

@Data
public class ItemResult extends ErrorResponse {
	
	private static final long serialVersionUID = 1L;

    /**
     * Item Id for the result
     */
    @JsonProperty("item_id")
    private Long id;

    /**
     * Detailed Item info
     */
    private ItemInfo item;
    /**
     * Image URLs of the item that failed. Up to 9 images,
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("fail_image")
    private List<Image> failedImages;

    /**
     * Warning message of the item result
     */
    private String warning;

}
