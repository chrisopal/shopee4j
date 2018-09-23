package com.salesmore.yak.integration.shopee.model;

import com.salesmore.yak.integration.core.transport.ObjectMapperSingleton;
import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsIdRequest;
import com.salesmore.yak.integration.shopee.service.AbstractTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNull;

public class LogisticsIdRequestTest extends AbstractTest {

    @Test
    public void requestString() throws Exception{

        LogisticsIdRequest request =LogisticsIdRequest.builder()
                .ordersn("123456ABC").partnerId(PARTNER_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .shopId(SHOP_ID)
                .build();

        String json = ObjectMapperSingleton.getContext(LogisticsIdRequestTest.class).writerFor(LogisticsIdRequest.class).writeValueAsString(request);
        logger.info("final json: {}", json);
        assertNull(request.getAddressId());
    }
}
