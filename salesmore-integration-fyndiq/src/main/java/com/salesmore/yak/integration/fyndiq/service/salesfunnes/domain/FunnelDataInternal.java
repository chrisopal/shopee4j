package com.salesmore.yak.integration.fyndiq.service.salesfunnes.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.fyndiq.model.salesfunnels.FunnelData;

public class FunnelDataInternal implements FunnelData {

    public static final long serialVersionUID = 1L;

    private String date;
    @JsonProperty("product_viewed")
    private int productViewed;
    @JsonProperty("article_added")
    private int articleAdded;
    @JsonProperty("checkout_started")
    private int checkoutStarted;
    @JsonProperty("quantity_sold")
    private int quantitySold;

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public int getProductViewed() {
        return productViewed;
    }

    @Override
    public int getArticleAdded() {
        return articleAdded;
    }

    @Override
    public int getCheckoutStarted() {
        return checkoutStarted;
    }

    @Override
    public int getQuantitySold() {
        return quantitySold;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProductViewed(int productViewed) {
        this.productViewed = productViewed;
    }

    public void setArticleAdded(int articleAdded) {
        this.articleAdded = articleAdded;
    }

    public void setCheckoutStarted(int checkoutStarted) {
        this.checkoutStarted = checkoutStarted;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    @Override
    public String toString() {
        return "FunnelDataInternal{" +
                "date='" + date + '\'' +
                ", productViewed=" + productViewed +
                ", articleAdded=" + articleAdded +
                ", checkoutStarted=" + checkoutStarted +
                ", quantitySold=" + quantitySold +
                '}';
    }
}
