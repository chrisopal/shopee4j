package com.salesmore.yak.integration.fyndiq.service.salesfunnes.domain;

import com.salesmore.yak.integration.fyndiq.model.salesfunnels.ArticleFunnelData;
import com.salesmore.yak.integration.fyndiq.model.salesfunnels.ProductFunneldata;

import java.util.List;

public class ConcreteProductFunnelData implements ProductFunneldata {

    public static final long serialVersionUID = 1L;

    private String productId;

    private List<ArticleFunnelDataInternal> articles;

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public List<? extends ArticleFunnelData> getArticles() {
        return articles;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setArticles(List<ArticleFunnelDataInternal> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "ConcreteProductFunnelData{" +
                "productId='" + productId + '\'' +
                ", articles=" + articles +
                '}';
    }
}
