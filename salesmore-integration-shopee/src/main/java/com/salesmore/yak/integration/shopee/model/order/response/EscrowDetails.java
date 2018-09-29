package com.salesmore.yak.integration.shopee.model.order.response;

import com.salesmore.yak.integration.shopee.model.ObjectResult;
import lombok.Data;

@Data
public class EscrowDetails extends ObjectResult<EscrowDetail> {

    public static final long serialVersionUID = 1L;

    /**
     * Order Detail Information
     */
    private EscrowDetail order;

    @Override
    protected EscrowDetail value() {
        return order;
    }
}
