package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.model.logistics.response.Logistics;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;

public class LogisticsServiceTest extends AbstractTest {

    @Test
    public void getLogistics() throws Exception {
        List<Logistics> logisticsList = client().logistics().getLogistics(client().baseRequest());
        logger.info("Logistics List: {}", logisticsList);
        assertNotNull(logisticsList);
    }
}
