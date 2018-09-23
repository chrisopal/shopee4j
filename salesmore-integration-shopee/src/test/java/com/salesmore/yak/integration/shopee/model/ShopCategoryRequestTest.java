package com.salesmore.yak.integration.shopee.model;

import com.salesmore.yak.integration.core.transport.ObjectMapperSingleton;
import com.salesmore.yak.integration.shopee.model.shopcategory.request.ShopCategoryRequest;
import com.salesmore.yak.integration.shopee.model.shopcategory.response.CategoryItemIds;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShopCategoryRequestTest extends AbstractModelTest {

    @Test
    void categoryItemIdsTest() throws Exception {
        String resultJson = "{\"item\": [{\"item_id\": 123456}]}";

        CategoryItemIds itemIds = ObjectMapperSingleton.getContext(ShopCategoryRequestTest.class).readerFor(CategoryItemIds.class).readValue(resultJson);
        assertEquals(itemIds.getItems().get(0).getItemId(), new Long(123456));

    }
}
