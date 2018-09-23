package com.salesmore.yak.integration.shopee.model.item;

import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Image implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * image url
     */
    private String url;
}
