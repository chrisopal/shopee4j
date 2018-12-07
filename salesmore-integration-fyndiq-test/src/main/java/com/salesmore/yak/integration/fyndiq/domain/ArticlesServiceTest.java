package com.salesmore.yak.integration.fyndiq.domain;


import com.google.common.collect.Maps;
import com.salesmore.yak.integration.core.transport.ObjectMapperSingleton;
import com.salesmore.yak.integration.fyndiq.AbstractTest;
import com.salesmore.yak.integration.fyndiq.api.Builders;
import com.salesmore.yak.integration.fyndiq.model.articles.*;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.BulkActionBuilder;
import com.salesmore.yak.integration.fyndiq.model.common.EntityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ArticlesServiceTest extends AbstractTest {


    Logger logger = LoggerFactory.getLogger(ArticlesServiceTest.class);

    @Test
    public void create() throws Exception {
        ArticleCreate articleCreate = articleCreate();
        EntityResponse response = fqClient().articles().create(articleCreate);
        logger.info("created article id: {}", response.getId());
        assertEquals(fqClient.articles().get(response.getId()).getSku(), articleCreate.getSku());
    }

    @Test
    public void list() throws Exception {
        List<? extends Article> articles = fqClient().articles().list();

        for (Article article : articles) {
            logger.info("article :{}", article);
        }

        assertEquals(articles.size(), 8);
    }

    @Test
    public void listWithParams() throws Exception {
        Map<String, String> filteringParams = Maps.newHashMap();
        filteringParams.put("limit", "100");
        filteringParams.put("page", "1");

        List<? extends Article> articles = fqClient().articles().list(filteringParams);
        assertEquals(articles.size(), 8);
    }

    @Test
    public void get() throws Exception {
        Article article = fqClient().articles().get(articleId());
        assertEquals(article.getId(), articleId());
        assertEquals(article.getProductId(), "f9342ccfb50f36315b91ee76b2aac3ad");
    }

    @Test
    public void delete() throws Exception {
        String articleId = "f68b8fe7-0ae8-436b-a671-8cbc01b8b36b";
        fqClient().articles().delete(articleId);
        Article article = fqClient.articles().get(articleId);
        assertEquals(article.getStatus(), Status.DELETED);
    }

    @Test
    public void update() throws Exception {
        fqClient().articles().update(articleId(), articleUpdate());
        assertEquals(fqClient.articles().get(articleId()).getBrand(), articleUpdate().getBrand());
    }

    @Test
    public void updatePrice() throws Exception {
        fqClient().articles().updatePrice(articleId(), articlePrice());
        double amount = fqClient.articles().get(articleId()).getPrice().get(0).getValue().getAmount();

        double amountExpect = articlePrice().getPrice().get(0).getValue().getAmount();

        assertEquals(amount, amountExpect);
    }

    @Test
    public void updateQuantity() throws Exception {
        fqClient().articles().updateQuantity(articleId(), quantity());
        int quantity = fqClient.articles().get(articleId()).getQuantity();
        assertEquals(quantity, quantity().getQuantity());
    }

    @Test
    public void bulkAction() throws Exception {
        ArticleActionResponse articleActionResponse = fqClient().articles().bulkAction(bulkActions());

        assertEquals(articleActionResponse.getResponses().size(), 3);

        for(ArticleActionResponse.Result result : articleActionResponse.getResponses()){
            assertEquals(result.getCode(), "202");
        }
    }

    private ArticleCreate articleCreate() throws Exception {
        ArticleCreate articleCreate = Builders.article().sku("985")
                .parentSku("123")
                .status(Status.FOR_SALE)
                .quantity(100)
                .tags(Arrays.asList(Tag.Women_Fashion.value(), "Women", "Clothes"))
                .size("XL")
                .color("Blue")
                .brand("Guzzi")
                .gtin("222231111")
                .mainImage("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515367411_1024x1024.jpg?v=1520489296")
                .addImage("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515678037_large.jpg?v=1520489297")
                .addImage("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-489980972_large.jpg?v=1520489299")
                .addTitle("en-US", "Women Clothes 2018 V-Neck Floral Office Lady Womens Tops Blusa De Renda")
                .addMarket(Market.SE)
                .addDescription("en-US", "Women Clothes 2018 V-Neck Floral Office Lady Womens Tops Blusa De Renda")
                .addArticlePrice(Builders.price().addPrice(Market.SE, 45.99, "USD")
                        .addOriginalPrice(Market.SE, 25.0, "USD")
                        .addShippingPrice(Market.SE, 4, "USD").build())
                .addShippingTime(Market.SE, "3-5")
                .build();
        String articleCreateStr = ObjectMapperSingleton.getContext(ArticleCreate.class).writeValueAsString(articleCreate);
        logger.info("Article to Create: {}", articleCreateStr);
        return articleCreate;
    }

    private ArticleCreate articleUpdate() throws Exception {
        ArticleCreate articleUpdate = Builders.article().sku("985")
                .parentSku("123")
                .status(Status.FOR_SALE)
                .tags(Arrays.asList(Tag.Women_Fashion.value(), "Women", "Clothes", "Style"))
                .size("XL")
                .color("Blue")
                .brand("H&M")
                .gtin("66666")
                .mainImage("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515367411_1024x1024.jpg?v=1520489296")
                .addImage("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515678037_large.jpg?v=1520489297")
                .addImage("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-489980972_large.jpg?v=1520489299")
                .addTitle("en-US", "Women Clothes 2018 V-Neck Floral Office Lady Womens Tops Blusa De Renda")
                .addMarket(Market.SE)
                .addDescription("en-US", "XXXXX Floral Office Lady Womens Tops Blusa De Renda")
                .addShippingTime(Market.SE, "3-5")
                .build();
        String articleUpdateStr = ObjectMapperSingleton.getContext(ArticleCreate.class).writeValueAsString(articleUpdate);
        logger.info("Article to Update: {}", articleUpdateStr);
        return articleUpdate;
    }

    private ArticlePrice articlePrice() throws Exception {
        ArticlePrice articlePrice = Builders.price().addPrice(Market.SE, 35.88, "USD")
                .addOriginalPrice(Market.SE, 25.0, "USD")
                .addShippingPrice(Market.SE, 7, "USD").build();
        String articlePriceStr = ObjectMapperSingleton.getContext(ArticleCreate.class).writeValueAsString(articlePrice);
        logger.info("Article Price to Update: {}", articlePriceStr);
        return articlePrice;
    }

    private Quantity quantity() {
        return Builders.quantity().quantity(70).build();
    }

    public static String articleId() {
        return "0f5b7c8d-248e-43d1-a2ce-913286375249";
    }

    private List<BulkAction> bulkActions() throws Exception {
        BulkActionBuilder<ArticleCreate> bulkActionBuilder = Builders.bulkAction();
        BulkAction<ArticleCreate> updateAction = bulkActionBuilder.action(Action.UPDATE_ARTICLE).id(articleId()).body(articleUpdate()).build();

        BulkActionBuilder<ArticlePrice> priceBulkActionBuilder = Builders.bulkAction();
        BulkAction<ArticlePrice> priceAction = priceBulkActionBuilder.action(Action.UPDATE_ARTICLE_PRICE).id(articleId()).body(articlePrice()).build();

        BulkActionBuilder<Quantity> quantityBulkActionBuilder = Builders.bulkAction();
        BulkAction<Quantity> quantityBulkAction = quantityBulkActionBuilder.action(Action.UPDATE_ARTICLE_QUANTITY).id(articleId()).body(quantity()).build();

        List<BulkAction> bulkActions = new ArrayList<BulkAction>();

        bulkActions.add(updateAction);
        bulkActions.add(priceAction);
        bulkActions.add(quantityBulkAction);

        return bulkActions;
    }
}