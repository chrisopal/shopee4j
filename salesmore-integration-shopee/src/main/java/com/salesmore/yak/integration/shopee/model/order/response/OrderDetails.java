package com.salesmore.yak.integration.shopee.model.order.response;

import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetails implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Order
     */
    private List<OrderDetail> orders;

    /**
     * Orders that encountered error
     */
    private List<String> errors;
}
