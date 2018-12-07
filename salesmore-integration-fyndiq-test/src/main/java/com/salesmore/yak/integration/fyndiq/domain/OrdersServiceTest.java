package com.salesmore.yak.integration.fyndiq.domain;

import com.google.common.collect.Maps;
import com.salesmore.yak.integration.core.transport.ObjectMapperSingleton;
import com.salesmore.yak.integration.fyndiq.AbstractTest;
import com.salesmore.yak.integration.fyndiq.api.Builders;
import com.salesmore.yak.integration.fyndiq.api.domain.OrdersService;
import com.salesmore.yak.integration.fyndiq.model.orders.Order;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderActionResponse;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderCreate;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderCreateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class OrdersServiceTest extends AbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(OrdersService.class);

    private String orderId;

    @Test
    public void createTestOrder() throws Exception {
       OrderCreateResponse response = fqClient().orders().create(testOrderCreate());

       logger.info("order id: {}", response.getId());
       assertNotNull(response);
    }


    @Test
    public void get() throws Exception {
        Order order = fqClient().orders().get(orderId);
        logger.info("order info: {}", order);
        assertEquals(orderId, order.getId());
        assertEquals(ArticlesServiceTest.articleId(), order.getArticleId());
    }

    @Test
    public void list() throws Exception {
        Map<String, String> filteringParams = Maps.newHashMap();
        filteringParams.put("limit", "100");
        filteringParams.put("page", "1");
        List<? extends Order> orders = fqClient().orders().list(filteringParams);
        assertEquals(orders.size(), 7);
    }

    @Test
    public void fulfill() throws Exception {
        OrderActionResponse response = fqClient().orders().fulfill(orderId);
        assertNotNull(response.getDescription());
    }

    @Test
    public void cancel() throws Exception {
        OrderActionResponse response = fqClient().orders().cancel(orderId);
        assertNotNull(response.getDescription());
    }

    private OrderCreate testOrderCreate() throws Exception{

        OrderCreate orderCreate = Builders.order().articleId(ArticlesServiceTest.articleId()).quanitity(10).build();
        String orderCreateStr = ObjectMapperSingleton.getContext(OrderCreate.class).writeValueAsString(orderCreate);
        logger.info("order create: {}", orderCreateStr);
        return orderCreate;
    }

    @BeforeTest
    public void getOrderId() throws Exception{

        orderId = fqClient().orders().create(testOrderCreate()).getId();
    }

}
