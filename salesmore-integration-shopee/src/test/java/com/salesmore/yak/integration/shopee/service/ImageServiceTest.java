package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.api.Builders;
import com.salesmore.yak.integration.shopee.model.image.request.ImageUpload;
import com.salesmore.yak.integration.shopee.model.image.response.ImageUploadResult;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;

public class ImageServiceTest extends AbstractTest {

    @Test
    public void uploadImages() {
        List<ImageUploadResult> imageUploadResultList = client().image().uploadImages(imageUploadRequest());
        logger.info("Image Upload List: {}", imageUploadResultList);
        //[ImageUploadResult(imageUrl=https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515367411_1024x1024.jpg?v=1520489296, shopeeImageUrl=http://f.shopee.sg/file/d7f5505a16380c2c6731d7728bb4fac8),
        // ImageUploadResult(imageUrl=https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515678037_large.jpg?v=1520489297, shopeeImageUrl=http://f.shopee.sg/file/1e0b4f498169766fce0178f2cea19024),
        // ImageUploadResult(imageUrl=https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-489980972_large.jpg?v=1520489299, shopeeImageUrl=http://f.shopee.sg/file/19322830f7b3294b2fcfef69231d668d)]
        assertNotNull(imageUploadResultList);
    }

    private ImageUpload imageUploadRequest() {
        return Builders.imageUpload()
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .image("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515367411_1024x1024.jpg?v=1520489296")
                .image("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515678037_large.jpg?v=1520489297")
                .image("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-489980972_large.jpg?v=1520489299")
                .build();
    }
}
