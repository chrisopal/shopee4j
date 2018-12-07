package com.salesmore.yak.integration.fyndiq.service.salesfunnes.domain;

import com.salesmore.yak.integration.fyndiq.model.salesfunnels.ArticleFunnelData;
import com.salesmore.yak.integration.fyndiq.model.salesfunnels.FunnelData;

import java.util.List;

public class ArticleFunnelDataInternal implements ArticleFunnelData {

    public static final long serialVersionUID = 1L;

    private String articleId;

    private List<FunnelDataInternal> stats;

    @Override
    public String getArticleId() {
        return articleId;
    }

    @Override
    public List<? extends FunnelData> getStats() {
        return stats;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setStats(List<FunnelDataInternal> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "ArticleFunnelDataInternal{" +
                "articleId='" + articleId + '\'' +
                ", stats=" + stats +
                '}';
    }
}
