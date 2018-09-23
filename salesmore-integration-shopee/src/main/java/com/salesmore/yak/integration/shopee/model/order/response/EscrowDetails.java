package com.salesmore.yak.integration.shopee.model.order.response;

import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

@Data
public class EscrowDetails implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Order Detail Information
     */
    private EscrowDetail order;
}
