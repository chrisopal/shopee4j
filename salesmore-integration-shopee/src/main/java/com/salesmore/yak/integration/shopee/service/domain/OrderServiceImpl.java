package com.salesmore.yak.integration.shopee.service.domain;


import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.shopee.api.domain.OrderService;
import com.salesmore.yak.integration.shopee.model.order.request.*;
import com.salesmore.yak.integration.shopee.model.order.response.EscrowDetails;
import com.salesmore.yak.integration.shopee.model.order.response.OrderActionResult;
import com.salesmore.yak.integration.shopee.model.order.response.OrderDetails;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.salesmore.yak.integration.shopee.constants.PathConstants.*;
import static com.salesmore.yak.integration.shopee.model.order.response.OrderBasics.OrderBasicsList;

public class OrderServiceImpl extends BaseRestClientService implements OrderService {

    @Override
    public OrderActionResult addOrderNote(OrderNote orderNote) {
        checkNotNull(orderNote);
        checkNotNull(orderNote.getOrdersn());
        return post(OrderActionResult.class, uri(ORDER_ADD_NOTE_RELATIVE_PATH)).entity(orderNote).executeWithErrorResponse();
    }

    @Override
    public OrderActionResult cancelOrder(OrderCancellation orderCancellation) {
        checkNotNull(orderCancellation);
        checkNotNull(orderCancellation.getCancelReason());
        return post(OrderActionResult.class, uri(ORDER_CANCEL_RELATIVE_PATH)).entity(orderCancellation).executeWithErrorResponse();
    }

    @Override
    public EscrowDetails getEscrowDetails(OrderIdRequest idRequest) {
        checkNotNull(idRequest);
        checkNotNull(idRequest.getOrdersn());
        return post(EscrowDetails.class, uri(ORDER_GET_ESCROW_DETAIL_RELATIVE_PATH)).entity(idRequest).execute();
    }

    @Override
    public OrderDetails getOrderDetails(OrderIdsRequest idsRequest) {
        checkNotNull(idsRequest);
        checkArgument(idsRequest.getOrdersns() != null && !idsRequest.getOrdersns().isEmpty() );
        return post(OrderDetails.class, uri(ORDER_GET_ORDER_DETAIL_RELATIVE_PATH)).entity(idsRequest).execute();

    }

    @Override
    public OrderBasicsList getOrdersByStatus(OrderPaginationRequest query) {
        checkNotNull(query);
        checkNotNull(query.getStatus());
        return post(OrderBasicsList.class, uri(ORDER_GET_BY_STATUS_RELATIVE_PATH)).entity(query).execute();
    }

    @Override
    public OrderBasicsList getOrderList(OrderPaginationRequest query) {
        checkNotNull(query);
        checkNotNull(query.getStatus());
        return post(OrderBasicsList.class, uri(ORDER_GET_BASICS_RELATIVE_PATH)).entity(query).execute();

    }

    @Override
    public OrderActionResult acceptBuyerCancellation(OrderIdRequest idRequest) {
        checkNotNull(idRequest);
        checkNotNull(idRequest.getOrdersn());
        return post(OrderActionResult.class, uri(ORDER_ACCEPT_BUYER_CANCELLATION_RELATIVE_PATH)).entity(idRequest).execute();

    }

    @Override
    public OrderActionResult rejectBuyerCancellation(OrderIdRequest idRequest) {
        checkNotNull(idRequest);
        checkNotNull(idRequest.getOrdersn());
        return post(OrderActionResult.class, uri(ORDER_REJECT_BUYER_CANCELLATION_RELATIVE_PATH)).entity(idRequest).execute();

    }
}
