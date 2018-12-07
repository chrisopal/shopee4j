package com.salesmore.yak.integration.fyndiq.api.domain;

import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.fyndiq.model.salesfunnels.ProductFunneldata;

/**
 *
 * Sales Funnels Operation APIs
 *
 */
public interface SalesFunnelsService extends RestService {

    /**
     * Get Product Sales Funnel Data
     *
     * @param productId of the unique product
     * @return sales funnel data
     */
    ProductFunneldata getSalesFunnelData(String productId);
}
