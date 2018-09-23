package com.salesmore.yak.integration.shopee.api.domain;


import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsIdRequest;
import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsInitRequest;
import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsIdsRequest;
import com.salesmore.yak.integration.shopee.model.logistics.response.*;

import java.util.List;

import static com.salesmore.yak.integration.shopee.model.logistics.response.TrackingInfo.TrackingInfoResult;

/**
 * Logistics Service
 */
public interface LogisticsService extends RestService {

    /**
     * Get Logistics
     *
     * @param baseRequest request params
     * @return logistics list
     */
    List<Logistics> getLogistics(BaseRequest baseRequest);

    /**
     * Get Parameters For Init
     * @param request order serial number
     * @return result
     */
    ParameterForInit getParametersForInit(LogisticsIdRequest request);

    /**
     * Get Address
     *
     * @param baseRequest request
     * @return list of address
     */
    List<Address> getAddresses(BaseRequest baseRequest);

    /**
     * Get Time Slot
     *
     * @param request request params
     * @return list of pick up time
     */
    List<PickupTime> getTimeSlot(LogisticsIdRequest request);
    /**
     * Get Branch
     *
     * @param request request
     * @return list of address
     */
    List<Branch> getBranches(LogisticsIdRequest request);


    /**
     * Get Logistics Info
     *
     * @param request order sn
     * @return logistics info
     */
    LogisticsInfo getLogisticsInfo(LogisticsIdRequest request);

    /**
     * Init Logistics
     *
     * @param request init params
     * @return tracking number
     */
    TrackingNumber initLogistics(LogisticsInitRequest request);

    /**
     *
     * @param idsRequest order ids list
     * @return airway bills result
     */
    AirwayBillsResult getAirwayBills(LogisticsIdsRequest idsRequest);

    /**
     * Get Order Logistics
     *
     * @param request order id
     * @return order logistics
     */
    OrderLogistics getOrderLogistics(LogisticsIdRequest request);

    /**
     * Get Logistics Message
     *
     * @param request order id and tracking number
     * @return tracking info
     */
    TrackingInfoResult getLogisticsMessage(LogisticsIdRequest request);
}
