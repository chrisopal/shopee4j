package com.salesmore.yak.integration.shopee.model;

import com.salesmore.yak.integration.core.transport.ObjectMapperSingleton;
import com.salesmore.yak.integration.shopee.model.item.Category;
import com.salesmore.yak.integration.shopee.model.item.Logistic;
import org.testng.annotations.Test;

import static com.salesmore.yak.integration.shopee.model.shopcategory.response.CategoryItemId.CategoryItemIds;
import static org.testng.Assert.assertEquals;

public class ShopCategoryRequestTest extends AbstractModelTest {

    @Test
    void categoryItemIdsTest() throws Exception {
        String resultJson = "{\"item\": [{\"item_id\": 123456}]}";

        CategoryItemIds itemIds = ObjectMapperSingleton.getContext(ShopCategoryRequestTest.class).readerFor(CategoryItemIds.class).readValue(resultJson);
        assertEquals(itemIds.first().getItemId(), new Long(123456));

    }

    @Test
    void categories() throws Exception {
        String resultJson = "{\n" +
                "    \"categories\": [\n" +
                "        {\n" +
                "            \"parent_id\": 0,\n" +
                "            \"has_children\": true,\n" +
                "            \"category_id\": 13016,\n" +
                "            \"category_name\": \"Men's Wear\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"parent_id\": 13016,\n" +
                "            \"has_children\": true,\n" +
                "            \"category_id\": 13023,\n" +
                "            \"category_name\": \"Skincare\"\n" +
                "        }\n" +
                "     ]\n" +
                "}\n";
        Category.Categories items = ObjectMapperSingleton.getContext(ShopCategoryRequestTest.class).readerFor(Category.Categories.class).readValue(resultJson);
        logger.info("items: {}", items);
        assertEquals(items.getList().size(), 2);
    }

    @Test
    public void logistic() throws Exception {
        String resultJson = "{\"logistic_name\": \"Registered Air Mail\", \"shipping_fee\": 0.4, \"enabled\": true, \"logistic_id\": 18003, \"is_free\": false}";
        Logistic logistic = ObjectMapperSingleton.getContext(ShopCategoryRequestTest.class).readerFor(Logistic.class).readValue(resultJson);
        logger.info("logistic: {}", logistic);
        assertEquals(logistic.getId(), new Long(18003));
    }

 }
