package com.salesmore.yak.integration.shopee.service.domain;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.shopee.api.domain.LogisticsService;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsIdRequest;
import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsIdsRequest;
import com.salesmore.yak.integration.shopee.model.logistics.request.LogisticsInitRequest;
import com.salesmore.yak.integration.shopee.model.logistics.response.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import static com.salesmore.yak.integration.shopee.constants.PathConstants.*;
import static com.salesmore.yak.integration.shopee.model.logistics.response.Logistics.LogisticsList;
import static com.salesmore.yak.integration.shopee.model.logistics.response.Address.Addresses;
import static com.salesmore.yak.integration.shopee.model.logistics.response.PickupTime.PickupTimeSlots;
import static com.salesmore.yak.integration.shopee.model.logistics.response.Branch.Branches;
import static com.salesmore.yak.integration.shopee.model.logistics.response.OrderLogistics.OrderLogisticsWrapper;
import static com.salesmore.yak.integration.shopee.model.logistics.response.TrackingInfo.TrackingInfoResult;
/**
 * Logistics Service Implementation
 */
public class LogisticsServiceImpl extends BaseRestClientService implements LogisticsService {
    @Override
    public List<Logistics> getLogistics(BaseRequest baseRequest) {
        checkNotNull(baseRequest);
        return post(LogisticsList.class, uri(LOGISTICS_GET_RELATIVE_PATH)).entity(baseRequest).executeWithErrorResponse().getList();
    }

    @Override
    public ParameterForInit getParametersForInit(LogisticsIdRequest request) {
        checkNotNull(request);
        checkNotNull(request.getOrdersn());
        return post(ParameterForInit.class, uri(LOGISTICS_GET_PARAMETER_INIT_RELATIVE_PATH)).entity(request).executeWithErrorResponse();
    }

    @Override
    public List<Address> getAddresses(BaseRequest baseRequest) {
        checkNotNull(baseRequest);
        return post(Addresses.class, uri(LOGISTICS_GET_ADDRESS_RELATIVE_PATH)).entity(baseRequest).executeWithErrorResponse().getList();
    }

    @Override
    public List<PickupTime> getTimeSlot(LogisticsIdRequest request) {
        checkNotNull(request);
        checkArgument(!StringUtils.isEmpty(request.getOrdersn()) && request.getAddressId() != null );
        return post(PickupTimeSlots.class, uri(LOGISTICS_GET_TIMESLOT_RELATIVE_PATH)).entity(request).executeWithErrorResponse().getList();

    }

    @Override
    public List<Branch> getBranches(LogisticsIdRequest request) {
        checkNotNull(request);
        checkArgument(!StringUtils.isEmpty(request.getOrdersn()));
        return post(Branches.class, uri(LOGISTICS_GET_BRANCH_RELATIVE_PATH)).entity(request).executeWithErrorResponse().getList();
    }

    @Override
    public LogisticsInfo getLogisticsInfo(LogisticsIdRequest request) {
        checkNotNull(request);
        checkArgument(!StringUtils.isEmpty(request.getOrdersn()));
        return post(LogisticsInfo.class, uri(LOGISTICS_GET_INFO_RELATIVE_PATH)).entity(request).executeWithErrorResponse();
    }

    @Override
    public TrackingNumber initLogistics(LogisticsInitRequest request) {
        checkNotNull(request);
        checkNotNull(request.getOrdersn());
        return post(TrackingNumber.class, uri(LOGISTICS_INIT_RELATIVE_PATH)).entity(request).executeWithErrorResponse();
    }

    @Override
    public AirwayBillsResult getAirwayBills(LogisticsIdsRequest idsRequest) {
        checkNotNull(idsRequest);
        checkArgument(idsRequest.getOrdersns() != null && !idsRequest.getOrdersns().isEmpty(), "Ordersn List must not be empty.");
        return post(AirwayBillsResult.class, uri(LOGISTICS_GET_AIRWAY_BILL_RELATIVE_PATH)).entity(idsRequest).executeWithErrorResponse();
    }

    @Override
    public OrderLogistics getOrderLogistics(LogisticsIdRequest request) {
        checkNotNull(request);
        checkArgument(!StringUtils.isEmpty(request.getOrdersn()));
        return post(OrderLogisticsWrapper.class, uri(LOGISTICS_GET_ORDER_LOGISTICS_RELATIVE_PATH)).entity(request).executeWithErrorResponse().get(OrderLogistics.class);
    }

    @Override
    public TrackingInfoResult getLogisticsMessage(LogisticsIdRequest request) {
        checkNotNull(request);
        checkArgument(!StringUtils.isEmpty(request.getOrdersn()));
        return post(TrackingInfoResult.class, uri(LOGISTICS_GET_TRACKING_RELATIVE_PATH)).entity(request).executeWithErrorResponse();
    }
}
