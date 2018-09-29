package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsIdRequest;
import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsIdsRequest;
import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsInitRequest;
import com.salesmore.yak.integration.shopee.model.logistics.request.internal.NonIntegrated;
import com.salesmore.yak.integration.shopee.model.logistics.response.*;
import com.salesmore.yak.integration.shopee.model.order.response.OrderBasics;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LogisticsServiceTest extends AbstractTest {

    private Long addressId;

    @Test
    public void getAddresses() throws Exception {
        List<Address> addresses = client().logistics().getAddresses(client().baseRequest());
        logger.info("Get Addresses List: {}", addresses);
        assertTrue(!addresses.isEmpty());
        addressId = addresses.get(0).getId();
    }

    @Test
    public void getBranches() throws Exception {
        List<Branch> branches = client().logistics().getBranches(logisticsIdRequest(null, null));
        logger.info("Get Branches List: {}", branches);
        assertTrue(!branches.isEmpty());
    }


    @Test
    public void getLogistics() throws Exception {
        List<Logistics> logisticsList = client().logistics().getLogistics(client().baseRequest());
        logger.info("Get Logistics List: {}", logisticsList);
        assertNotNull(logisticsList);
    }

    //<p>The requested URL /api/v1/logistics/init_info/get was not found on this server.</p>
    @Test
    public void getLogisticInfo() throws Exception {
        LogisticsInfo logisticsInfo = client().logistics().getLogisticsInfo(logisticsIdRequest(null, null));
        logger.info("Get Logistics Info Result: {}", logisticsInfo);
        assertNotNull(logisticsInfo);
    }

    @Test
    public void getLogisticsMessage() throws Exception {
        TrackingInfo.TrackingInfoResult trackingInfoResult = client().logistics().getLogisticsMessage(logisticsIdRequest(null, null));
        logger.info("Get Logistics Tracking Result: {}", trackingInfoResult);
    }

    @Test
    void getAirwayBillWithoutBatch() throws Exception {

        //airway without batch
        AirwayBillsResult airwayBillsResult = client().logistics().getAirwayBills(logisticsIdsRequest(false));
        logger.info("Get Airway Bills without Batch: {}", airwayBillsResult);
        assertNotNull(airwayBillsResult);

    }

    @Test
    void getAirwayBillWithBatch() throws Exception {

        //airway without batch
        AirwayBillsResult airwayBillsResult = client().logistics().getAirwayBills(logisticsIdsRequest(true));
        logger.info("Get Airway Bills in Batch: {}", airwayBillsResult);
        assertNotNull(airwayBillsResult);

    }

    @Test
    void initLogistics() throws Exception {
        TrackingNumber trackingNumber = client().logistics().initLogistics(logisticsInitRequest());
        logger.info("Init Logistics result: {}", trackingNumber);
        assertNotNull(trackingNumber);
    }

    private LogisticsInitRequest logisticsInitRequest() {
        return LogisticsInitRequest.builder().partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .ordersn(OrderServiceTest.ORDERSN)
                .nonIntegrated(NonIntegrated.builder().trackingNo("").build())
                .build();
    }

    private LogisticsIdsRequest logisticsIdsRequest(boolean batch) throws Exception{
        List<OrderBasics> orderBasicsList = getOrderList();
        LogisticsIdsRequest.LogisticsIdsRequestBuilder builder = LogisticsIdsRequest.builder()
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .batch(batch);
        for (OrderBasics orderBasics : orderBasicsList ){
            builder.ordersn(orderBasics.getOrdersn());
        }
        return builder.build();
    }

    @Test
    public void getOrderLogistics() throws Exception {
        OrderLogistics orderLogistics = client().logistics().getOrderLogistics(logisticsIdRequest(null, null));
        logger.info("Get Order Logistics Result: {}", orderLogistics);
        assertNotNull(orderLogistics);
    }

    @Test
    public void getParametersForInit() throws Exception {
        ParameterForInit parameterForInit = client().logistics().getParametersForInit(logisticsIdRequest(null, null));
        logger.info("Get Logistics Parameters For Init Result: {}", parameterForInit);
        assertNotNull(parameterForInit);
    }

    @Test
    public void getTimeSlot() throws Exception {
        List<PickupTime> pickupTimes = client().logistics().getTimeSlot(logisticsIdRequest(addressId, null));
        logger.info("Get PickUp Times List: {}", pickupTimes);
        assertTrue(!pickupTimes.isEmpty());
    }

    private LogisticsIdRequest logisticsIdRequest(Long addressId, String trackingNo) {
        return LogisticsIdRequest.builder().ordersn(OrderServiceTest.ORDERSN)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .addressId(addressId)
                .trackingNumber(trackingNo)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }






}
