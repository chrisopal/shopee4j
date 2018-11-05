package com.salesmore.yak.integration.shopee.model.order.response;

import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OrderDetails extends ErrorResponse implements ModelEntity {

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
