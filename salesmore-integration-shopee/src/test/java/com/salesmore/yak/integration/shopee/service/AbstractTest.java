package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.api.Builders;
import com.salesmore.yak.integration.shopee.api.ShopeeClient;
import com.salesmore.yak.integration.shopee.model.PaginationBaseRequest;
import com.salesmore.yak.integration.shopee.model.PaginationBaseRequest.PaginationBaseRequestBuilder;
import com.salesmore.yak.integration.shopee.service.client.ShopeeClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    static {
        System.setProperty("log4j.configurationFile","./log4j.xml");
    }

    protected static final String TEST_SERVER_ENDPOINT = "https://partner.uat.shopeemobile.com/api/v1";
    protected static final long PARTNER_ID = 100421;
    protected static final String PARTNER_KEY = "f44262e6ef143ca4cff63d3f2a8dabfada3a5581abfbef7a8b52197da4148c9a";
    protected static final long SHOP_ID = 205753;

    private static final ShopeeClient shopeeClient = ShopeeClientFactory.newClient(PARTNER_ID, PARTNER_KEY, SHOP_ID, TEST_SERVER_ENDPOINT);

    protected ShopeeClient client() {
        return shopeeClient;
    }

    @SuppressWarnings("rawtypes")
	public static PaginationBaseRequest paginationBaseRequest() {
        return ((PaginationBaseRequestBuilder) Builders.paginationBaseRequest()
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000))
                .paginationEntriesPerPage(10L)
                .paginationOffset(0)
                .build();
    }
}
