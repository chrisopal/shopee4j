package com.salesmore.yak.integration.fyndiq.model.salesfunnels;

import com.salesmore.yak.integration.core.model.ModelEntity;

import java.util.List;

/**
 * Product Funnel Data includes All Articles
 */
public interface ProductFunneldata extends ModelEntity {

    /**
     * Get Product Id
     *
     * @return product id
     */
    String getProductId();

    /**
     * Get Article Funnel Data
     *
     * @return articles funnel data
     */
    List<? extends ArticleFunnelData> getArticles();
}
