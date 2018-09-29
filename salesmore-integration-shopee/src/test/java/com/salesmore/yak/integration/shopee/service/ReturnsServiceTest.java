package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.model.returns.request.ReturnsPaginationRequest;
import com.salesmore.yak.integration.shopee.model.returns.response.ReturnDetail.ReturnDetails;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

public class ReturnsServiceTest extends AbstractTest {

    @Test
    void getReturnsList() throws Exception {
    	ReturnDetails details = client().returns().getReturnList(paginationRequest());
    	logger.info("Returns List: {}", details.getList());
    	assertNotNull(details.getList());

    }

    public static ReturnsPaginationRequest paginationRequest() {
        return ReturnsPaginationRequest.builder()
                .partnerId(PARTNER_ID)
                .paginationEntriesPerPage(10L)
                .paginationOffset(0)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }
}
