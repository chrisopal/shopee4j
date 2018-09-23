package com.salesmore.yak.integration.shopee.model;

import com.salesmore.yak.integration.core.transport.ObjectMapperSingleton;
import org.testng.annotations.Test;

import static com.salesmore.yak.integration.shopee.model.image.response.ImageUploadResult.ImageUploadResults;
import static org.testng.Assert.assertEquals;

public class ImageUploadResultsTest extends AbstractModelTest{


    @Test
    public void mapping() throws Exception {

        String response = "{\n" +
                "\t\"images\": [{\"image_url\": \"http://a.1.png\", \"shopee_image_url\": \"http://shopee.a.1.png\"}, \n" +
                "\t{\"image_url\": \"http://b.1.png\", \"shopee_image_url\": \"http://shopee.b.1.png\"}]\n" +
                "}";

        ImageUploadResults a = ObjectMapperSingleton.getContext(ImageUploadResultsTest.class).readerFor(ImageUploadResults.class).readValue(response);
        logger.info("result: {}", a.getList());

        assertEquals(a.getList().size(), 2);
    }
}
