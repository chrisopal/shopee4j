package com.salesmore.yak.integration.shopee.model.image.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.common.ListResult;
import lombok.Data;

import java.util.List;

@Data
public class ImageUploadResult implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Origin image url
     */
    @JsonProperty("image_url")
    private String imageUrl;

    /**
     * Shopee image url
     */
    @JsonProperty("shopee_image_url")
    private String shopeeImageUrl;

    @Data
    public static class ImageUploadResults extends ListResult<ImageUploadResult> {

        public static final long serialVersionUID = 1L;

        private List<ImageUploadResult> images;

        @Override
        protected List<ImageUploadResult> value() {
            return images;
        }
    }


}
