package com.salesmore.yak.integration.shopee.service.domain;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.shopee.api.domain.ImageService;
import com.salesmore.yak.integration.shopee.model.image.request.ImageUpload;
import com.salesmore.yak.integration.shopee.model.image.response.ImageUploadResult;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.salesmore.yak.integration.shopee.constants.PathConstants.IMAGE_UPLOAD_RELATIVE_PATH;
import static com.salesmore.yak.integration.shopee.model.image.response.ImageUploadResult.ImageUploadResults;


public class ImageServiceImpl extends BaseRestClientService implements ImageService {

    private static final int IMAGE_MAX_SIZE = 9;

    @Override
    public List<ImageUploadResult> uploadImages(ImageUpload imageUploadRequest) {
        checkNotNull(imageUploadRequest);
        checkArgument(imageUploadRequest.getImages() != null && imageUploadRequest.getImages().size() <= IMAGE_MAX_SIZE);
        return post(ImageUploadResults.class, uri(IMAGE_UPLOAD_RELATIVE_PATH)).entity(imageUploadRequest).executeWithErrorResponse().getList();
    }
}
