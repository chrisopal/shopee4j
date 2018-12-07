package com.salesmore.yak.integration.fyndiq.domain;

import com.salesmore.yak.integration.fyndiq.AbstractTest;
import com.salesmore.yak.integration.fyndiq.model.salesfunnels.ProductFunneldata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class SalesFunnelsServiceTest extends AbstractTest {

    private static final String PRODUCT_ID = "f9342ccfb50f36315b91ee76b2aac3ad";
    private static final Logger logger = LoggerFactory.getLogger(SalesFunnelsServiceTest.class);

    @Test
    public void list() throws Exception {
        ProductFunneldata productFunneldata = fqClient().salesFunnels().getSalesFunnelData(PRODUCT_ID);
        logger.info("sales funnel data: {}", productFunneldata);
        assertNotNull(productFunneldata);
    }

}
