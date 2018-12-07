package com.salesmore.yak.integration.fyndiq.model.salesfunnels;

import com.salesmore.yak.integration.core.model.ModelEntity;

import java.util.List;


/**
 *
 * Article Funnel Data statistics with 7 Days
 *
 */
public interface ArticleFunnelData extends ModelEntity {

    /**
     * Get Article Id composed product
     *
     * @return article id
     */
    String getArticleId();

    /**
     * Get Stats Data
     *
     * @return stats data within 7 days
     */
    List<? extends FunnelData> getStats();
}
