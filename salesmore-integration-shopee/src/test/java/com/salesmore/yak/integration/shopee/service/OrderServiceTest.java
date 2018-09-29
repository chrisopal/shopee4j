package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.model.common.OrderStatus;
import com.salesmore.yak.integration.shopee.model.order.request.*;
import com.salesmore.yak.integration.shopee.model.order.response.EscrowDetail;
import com.salesmore.yak.integration.shopee.model.order.response.OrderActionResult;
import com.salesmore.yak.integration.shopee.model.order.response.OrderBasics;
import com.salesmore.yak.integration.shopee.model.order.response.OrderBasics.OrderBasicsList;
import com.salesmore.yak.integration.shopee.model.order.response.OrderDetails;
import org.testng.annotations.Test;

import java.util.List;

import static com.salesmore.yak.integration.shopee.model.order.request.OrderCancellation.CancelReason;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderServiceTest extends AbstractTest {

    public static final String ORDERSN = "1809291137375GJ";

    @Test
    public void addOrderNote() throws Exception {
        OrderActionResult orderActionResult = client().order().addOrderNote(orderNote());
        logger.info("Add Order Note Result: {}", orderActionResult);
        assertEquals(orderActionResult.getOrdersn(), ORDERSN);
    }

	@Test
	public void getOrderList_thenGetOrderDetails() throws Exception {
        //Get Order List
		List<OrderBasics> orderBasicsList = getOrderList();
		assertTrue(!orderBasicsList.isEmpty());

		//Get Order Detail List
        OrderDetails orderDetails = client().order().getOrderDetails(orderIdsRequest(orderBasicsList));
        logger.info("Get Order Details Result: {}", orderDetails);
        assertEquals(orderDetails.getOrders().size(), orderBasicsList.size());
	}

    @Test
    public void getOrdersByStatus() throws Exception {
        OrderBasicsList orders = client().order().getOrdersByStatus(paginationRequestWithStatus());
        logger.info("Get Order Basics List by Status: {}", orders);
        assertTrue(!orders.getList().isEmpty());
    }
    
    @Test
    public void getEscrowDetail() throws Exception {
    	EscrowDetail escrowDetail = client().order().getEscrowDetails(orderIdRequest());
    	logger.info("Get Escrow Order Detail: {}", escrowDetail);
    	assertEquals(escrowDetail.getOrdersn(), ORDERSN);
    	
    }

    @Test
    public void s_cancelOrder() {
        OrderActionResult orderActionResult = client().order().cancelOrder(orderCancellation());
        logger.info("Cancel Order Result: {}", orderActionResult);
        assertEquals(orderActionResult.getOrdersn(), ORDERSN);
    }

    @Test
    public void xa_rejectBuyerCancellation() {
        OrderActionResult orderActionResult = client().order().rejectBuyerCancellation(orderIdRequest());
        logger.info("Reject Buyer Cancel Order Result: {}", orderActionResult);
        assertEquals(orderActionResult.getOrdersn(), ORDERSN);
    }

    @Test
    public void x_acceptBuyerCancellation() {
        OrderActionResult orderActionResult = client().order().acceptBuyerCancellation(orderIdRequest());
        logger.info("Accept Buyer Cancel Order Result: {}", orderActionResult);
        assertEquals(orderActionResult.getOrdersn(), ORDERSN);
    }

    private OrderCancellation orderCancellation() {
        return OrderCancellation.builder().ordersn(ORDERSN)
                .itemId(1524731L)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .cancelReason(CancelReason.COD_NOT_SUPPORTED)
                .build();
    }

    private OrderIdsRequest orderIdsRequest(List<OrderBasics> orderBasicsList) {
        OrderIdsRequest.OrderIdsRequestBuilder builder = OrderIdsRequest.builder().partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000);
        for(OrderBasics orderBasics : orderBasicsList){
            builder.ordersn(orderBasics.getOrdersn());
        }
        return builder.build();
    }
    
    private OrderIdRequest orderIdRequest() {
    	return OrderIdRequest.builder()
    			.ordersn(ORDERSN)
    			.partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }

    private OrderNote orderNote() {
	    return OrderNote.builder().ordersn(ORDERSN)
                .note("order note from salesmore api client")
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }



    private OrderPaginationRequest paginationRequestWithStatus() throws Exception{
        return OrderPaginationRequest.builder()
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .status(OrderStatus.CANCELLED)
                .createTimeFrom(System.currentTimeMillis()/1000-10*24*60*60)
                .createTimeTo(System.currentTimeMillis()/1000+2*24*60*60)
                .paginationEntriesPerPage(10L)
                .paginationOffset(0)
                .build();
    }
}
