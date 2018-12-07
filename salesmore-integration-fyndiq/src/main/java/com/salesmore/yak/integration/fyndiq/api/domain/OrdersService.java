package com.salesmore.yak.integration.fyndiq.api.domain;

import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.fyndiq.model.orders.Order;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderActionResponse;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderCreate;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderCreateResponse;

import java.util.List;
import java.util.Map;

/**
 * Orders Service Operation APIs
 *
 */
public interface OrdersService extends RestService {

    /**
     * Create Test Order (Used for test as well)
     *
     * @param orderCreate order to create
     * @return order create response
     */
    OrderCreateResponse create(OrderCreate orderCreate);

    /**
     * Get Order Info
     *
     * @param id of order
     * @return order
     */
    Order get(String id);

    /**
     * List Orders
     * @param filteringParams state, limit, page
     * @return list of order
     */
    List<? extends Order> list(Map<String, String> filteringParams);

    /**
     * Fulfill an Order
     *
     * @param orderId to fulfill
     * @return action response
     */
    OrderActionResponse fulfill(String orderId);

    /**
     * Cancel an Order
     *
     * @param orderId to fulfill
     * @return action response
     */
    OrderActionResponse cancel(String orderId);
}
