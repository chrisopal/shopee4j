package com.salesmore.yak.integration.shopee.model.logistics.response.internal;


import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Data;

@Data
public class ItemDimension implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The max height limit.
     */
    private float height;

    /**
     * The max width limit.
     */
    private float width;

    /**
     * The max length limit.
     */
    private float length;

    /**
     * The unit for the limit.
     */
    private String unit;
}
