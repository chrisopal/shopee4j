package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TrackingLogisticsStatus {
    UNRECOGNIZED,
    INITIAL,
    ORDER_INIT,
    ORDER_SUBMITTED,
    ORDER_FINALIZED,
    ORDER_CREATED,
    PICKUP_REQUESTED,
    PICKUP_PENDING,
    PICKED_UP,
    DELIVERY_PENDING,
    DELIVERED,
    PICKUP_RETRY,
    TIMEOUT,
    LOST,
    UPDATE,
    UPDATE_SUBMITTED,
    UPDATE_CREATED,
    RETURN_STARTED,
    RETURNED,
    RETURN_PENDING,
    RETURN_INITIATED,
    EXPIRED,
    CANCEL,
    CANCEL_CREATED,
    CANCELED,
    FAILED_ORDER_INIT,
    FAILED_ORDER_SUBMITTED,
    FAILED_ORDER_CREATED,
    FAILED_PICKUP_REQUESTED,
    FAILED_PICKED_UP,
    FAILED_DELIVERED,
    FAILED_UPDATE_SUBMITTED,
    FAILED_UPDATE_CREATED,
    FAILED_RETURN_STARTED,
    FAILED_RETURNED,
    FAILED_CANCEL_CREATED,
    FAILED_CANCELED;

    @JsonCreator
    public static TrackingLogisticsStatus value(String v) {
        if (v == null) return UNRECOGNIZED;
        try {
            return valueOf(v);
        } catch (IllegalArgumentException e) {
            return UNRECOGNIZED;
        }
    }

    @JsonValue
    public String value() {
        return name();
    }
}
