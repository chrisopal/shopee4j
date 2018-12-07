package com.salesmore.yak.integration.fyndiq.service.orders.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.salesmore.yak.integration.fyndiq.model.orders.OrderCreate;
import com.salesmore.yak.integration.fyndiq.model.orders.builder.OrderCreateBuilder;

public class ConcreteOrderCreate implements OrderCreate {

    public static final long serialVersionUID = 1L;

    @JsonProperty("article_id")
    private String articleId;
    private int quantity;

    @Override
    public String getArticleId() {
        return articleId;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public static OrderCreateBuilder builder() {
        return new ConcreteOrderCreateBuilder();
    }

    @Override
    public OrderCreateBuilder toBuilder() {
        return new ConcreteOrderCreateBuilder(this);
    }

    public static class ConcreteOrderCreateBuilder implements OrderCreateBuilder {

        ConcreteOrderCreate c;

        public ConcreteOrderCreateBuilder() {
            this(new ConcreteOrderCreate());
        }

        public ConcreteOrderCreateBuilder(ConcreteOrderCreate c) {
            this.c = c;
        }

        @Override
        public OrderCreateBuilder articleId(String articleId) {
            c.articleId = articleId;
            return this;
        }

        @Override
        public OrderCreateBuilder quanitity(int quanity) {
            c.quantity = quanity;
            return this;
        }

        @Override
        public OrderCreate build() {
            return c;
        }

        @Override
        public OrderCreateBuilder from(OrderCreate in) {
            c = (ConcreteOrderCreate)in;
            return this;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("articleId", articleId )
                .add("quantity", quantity)
                .toString();
    }
}
