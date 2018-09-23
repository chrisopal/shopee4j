package com.salesmore.yak.integration.shopee.api.domain;

import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.shopee.model.image.request.ImageUpload;
import com.salesmore.yak.integration.shopee.model.image.response.ImageUploadResult;

import java.util.List;

/**
 * Shopee Image Service
 */
public interface ImageService extends RestService {

    /**
     * Uploads Images
     *
     * @param imageUploadRequest images to uplods
     * @return uploaded images result
     */
    List<ImageUploadResult> uploadImages(ImageUpload imageUploadRequest);

}
