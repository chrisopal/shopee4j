package com.salesmore.yak.integration.fyndiq.service.orders;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.fyndiq.api.domain.OrdersService;
import com.salesmore.yak.integration.fyndiq.constants.ClientConstants;
import com.salesmore.yak.integration.fyndiq.model.orders.Order;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderActionResponse;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderCreate;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderCreateResponse;
import com.salesmore.yak.integration.fyndiq.service.orders.domain.ConcreteOrder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OrdersServiceImpl extends BaseRestClientService implements OrdersService {

    @Override
    public OrderCreateResponse create(OrderCreate orderCreate) {
        return post(OrderCreateResponse.class, uri(ClientConstants.ORDERS_PATH)).entity(orderCreate).execute();
    }

    @Override
    public Order get(String id) {
        return get(ConcreteOrder.class, uri(ClientConstants.GET_ORDER_PATH, id)).execute();
    }

    @Override
    public List<? extends Order> list(Map<String, String> filteringParams) {
        return Arrays.asList(get(ConcreteOrder[].class, uri(ClientConstants.ORDERS_PATH)).params(filteringParams).execute());
    }

    @Override
    public OrderActionResponse fulfill(String orderId) {
        return put(OrderActionResponse.class, uri(ClientConstants.FULFILL_ORDER_PATH, orderId)).execute();
    }

    @Override
    public OrderActionResponse cancel(String orderId) {
        return put(OrderActionResponse.class, uri(ClientConstants.CANCEL_ORDER_PATH, orderId)).execute();
    }
}
