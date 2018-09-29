package com.salesmore.yak.integration.shopee.api.domain;

import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.shopee.model.order.request.*;
import com.salesmore.yak.integration.shopee.model.order.response.EscrowDetail;
import com.salesmore.yak.integration.shopee.model.order.response.OrderActionResult;
import com.salesmore.yak.integration.shopee.model.order.response.OrderDetails;

import static com.salesmore.yak.integration.shopee.model.order.response.OrderBasics.OrderBasicsList;

/**
 * Order Service
 */
public interface OrderService extends RestService {

    /**
     * Add Order Note
     *
     * @param orderNote note to add
     * @return result
     */
    OrderActionResult addOrderNote(OrderNote orderNote);

    /**
     * Cancel an Order
     *
     * @param orderCancellation order cancellation
     * @return result
     */
    OrderActionResult cancelOrder(OrderCancellation orderCancellation);

    /**
     * Get Escrow Details
     *
     * @param idRequest id request
     * @return escrow details
     */
    EscrowDetail getEscrowDetails(OrderIdRequest idRequest);

    /**
     *
     * @param idsRequest order ids to get
     * @return order lists
     */
    OrderDetails getOrderDetails(OrderIdsRequest idsRequest);

    /**
     * Get Orders By Status
     *
     * @param query query info
     * @return queried result
     */
    OrderBasicsList getOrdersByStatus(OrderPaginationRequest query);

    /**
     * Get Orders
     *
     * @param query query info
     * @return queried result
     */
    OrderBasicsList getOrderList(OrderPaginationRequest query);

    /**
     * Accept Buyer Cancellation
     * @param idRequest order id to cancel
     * @return result
     */
    OrderActionResult acceptBuyerCancellation(OrderIdRequest idRequest);

    /**
     * Reject Buyer Cancellation
     * @param idRequest order id
     * @return result
     */
    OrderActionResult rejectBuyerCancellation(OrderIdRequest idRequest);
}
