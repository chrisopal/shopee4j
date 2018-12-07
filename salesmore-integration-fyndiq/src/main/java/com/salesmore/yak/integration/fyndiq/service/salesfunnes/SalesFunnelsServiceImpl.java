package com.salesmore.yak.integration.fyndiq.service.salesfunnes;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.fyndiq.api.domain.SalesFunnelsService;
import com.salesmore.yak.integration.fyndiq.constants.ClientConstants;
import com.salesmore.yak.integration.fyndiq.model.salesfunnels.ProductFunneldata;
import com.salesmore.yak.integration.fyndiq.service.salesfunnes.domain.ConcreteProductFunnelData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SalesFunnelsServiceImpl extends BaseRestClientService implements SalesFunnelsService {

    private static final Logger logger = LoggerFactory.getLogger(SalesFunnelsServiceImpl.class);

    @Override
    public ProductFunneldata getSalesFunnelData(String productId) {
        return get(ConcreteProductFunnelData.class, uri(ClientConstants.SALES_FUNNEL_PATH, productId)).execute();
    }
}
