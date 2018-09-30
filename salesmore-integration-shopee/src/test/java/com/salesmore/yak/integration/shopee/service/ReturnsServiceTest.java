package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.model.common.ReturnDisputeReason;
import com.salesmore.yak.integration.shopee.model.returns.request.ReturnDisputeRequest;
import com.salesmore.yak.integration.shopee.model.returns.request.ReturnsIdRequest;
import com.salesmore.yak.integration.shopee.model.returns.request.ReturnsPaginationRequest;
import com.salesmore.yak.integration.shopee.model.returns.response.ReturnActionResult;
import com.salesmore.yak.integration.shopee.model.returns.response.ReturnDetail.ReturnDetails;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

public class ReturnsServiceTest extends AbstractTest {

    private static final String RETURNSN = "xxxxxx";

    @Test
    void getReturnsList() throws Exception {
    	ReturnDetails details = client().returns().getReturnList(paginationRequest());
    	logger.info("Returns List: {}", details.getList());
    	assertNotNull(details.getList());

    }

    @Test
    void confirmReturns() {
        ReturnActionResult actionResult = client().returns().confirmReturn(returnsIdRequest());
        logger.info("Confirm Return Result: {}", actionResult);
        assertNotNull(actionResult);
    }

    @Test
    void disputeReturns() {
        ReturnActionResult actionResult =  client().returns().disputeReturn(returnDisputeRequest());
        logger.info("Dispute Return Result: {}", actionResult);
        assertNotNull(actionResult);

    }

    private ReturnDisputeRequest returnDisputeRequest() {
        return ReturnDisputeRequest.builder()
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .returnsn(RETURNSN)
                .email("chrisopol@gmail.com")
                .disputeReason(ReturnDisputeReason.NON_RECEIPT)
                .image("https://cdn.shopify.com/s/files/1/0004/8693/2527/products/product-image-515678037_large.jpg?v=1520489297")
                .disputeTextReason("Non receipt received, need to dispute")
                .build();
    }

    private ReturnsIdRequest returnsIdRequest() {
        return ReturnsIdRequest.builder()
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .returnsn(RETURNSN)
                .build();
    }

    private ReturnsPaginationRequest paginationRequest() {
        return ReturnsPaginationRequest.builder()
                .partnerId(PARTNER_ID)
                .paginationEntriesPerPage(10L)
                .paginationOffset(0)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }
}
