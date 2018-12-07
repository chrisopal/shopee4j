package com.salesmore.yak.integration.fyndiq.service.orders.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.fyndiq.model.articles.Market;
import com.salesmore.yak.integration.fyndiq.model.articles.PriceValue;
import com.salesmore.yak.integration.fyndiq.model.orders.Order;
import com.salesmore.yak.integration.fyndiq.model.orders.ShippingAddress;
import com.salesmore.yak.integration.fyndiq.model.orders.State;

/**
 * Order Implementation
 */
public class ConcreteOrder implements Order {

    public static final long serialVersionUID = 1L;

    private String id;
    @JsonProperty("article_id")
    private String articleId;
    @JsonProperty("article_title")
    private String articleTitle;
    @JsonProperty("article_sku")
    private String articleSku;
    @JsonProperty("article_price")
    private PriceValue articlePrice;
    @JsonProperty("article_vat_rate")
    private String articleVatRate;
    @JsonProperty("shipping_vat_rate")
    private String shippingVatRate;
    int quantity;
    @JsonProperty("shipping_price")
    private PriceValue shippingPrice;
    @JsonProperty("total_price")
    private PriceValue totalPrice;
    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;

    private Market market;
    private State state;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("fulfill_before")
    private String fulfillBefore;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getArticleId() {
        return articleId;
    }

    @Override
    public String getArticleTitle() {
        return articleTitle;
    }

    @Override
    public String getArticleSku() {
        return articleSku;
    }

    @Override
    public PriceValue getArticlePrice() {
        return articlePrice;
    }

    @Override
    public String getArticleVatRate() {
        return articleVatRate;
    }

    @Override
    public PriceValue getShippingPrice() {
        return shippingPrice;
    }

    @Override
    public String getShippingVatRate() {
        return shippingVatRate;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public PriceValue getTotalPrice() {
        return totalPrice;
    }

    @Override
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public Market getMarket() {
        return market;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public String getCreatedAt() {
        return createdAt;
    }

    @Override
    public String fulfillBefore() {
        return fulfillBefore;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setArticleSku(String articleSku) {
        this.articleSku = articleSku;
    }

    public void setArticlePrice(PriceValue articlePrice) {
        this.articlePrice = articlePrice;
    }

    public void setArticleVatRate(String articleVatRate) {
        this.articleVatRate = articleVatRate;
    }

    public void setShippingVatRate(String shippingVatRate) {
        this.shippingVatRate = shippingVatRate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setShippingPrice(PriceValue shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public void setTotalPrice(PriceValue totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setFulfillBefore(String fulfillBefore) {
        this.fulfillBefore = fulfillBefore;
    }

    @Override
    public String toString() {
        return "ConcreteOrder{" +
                "id='" + id + '\'' +
                ", articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleSku='" + articleSku + '\'' +
                ", articlePrice=" + articlePrice +
                ", articleVatRate='" + articleVatRate + '\'' +
                ", shippingVatRate='" + shippingVatRate + '\'' +
                ", quantity=" + quantity +
                ", shippingPrice=" + shippingPrice +
                ", totalPrice=" + totalPrice +
                ", shippingAddress=" + shippingAddress +
                ", market=" + market +
                ", state=" + state +
                ", createdAt='" + createdAt + '\'' +
                ", fulfillBefore='" + fulfillBefore + '\'' +
                '}';
    }
}
