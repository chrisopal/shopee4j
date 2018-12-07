package com.salesmore.yak.integration.fyndiq.service.articles.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.salesmore.yak.integration.fyndiq.model.articles.ArticlePrice;
import com.salesmore.yak.integration.fyndiq.model.articles.Market;
import com.salesmore.yak.integration.fyndiq.model.articles.PriceInfo;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.ArticlePriceBuilder;

import java.util.List;

public class ConcreteArticlePrice implements ArticlePrice {

    private List<PriceInfo> price;

    @JsonProperty("original_price")
    private List<PriceInfo> originalPrice;

    @JsonProperty("shipping_price")
    private List<PriceInfo> shippingPrice;

    @Override
    public List<? extends PriceInfo> getPrice() {
        return this.price;
    }

    @Override
    public List<? extends PriceInfo> getOriginalPrice() {
        return this.originalPrice;
    }

    @Override
    public List<? extends PriceInfo> getShippingPrice() {
        return this.shippingPrice;
    }

    public static ConcreteArticlePriceBuilder builder(){
        return new ConcreteArticlePriceBuilder();
    }
    @Override
    public ArticlePriceBuilder toBuilder() {
        return new ConcreteArticlePriceBuilder(this);
    }

    public static class ConcreteArticlePriceBuilder implements ArticlePriceBuilder {

        ConcreteArticlePrice m;

        public ConcreteArticlePriceBuilder() {
            this(new ConcreteArticlePrice());
        }

        public ConcreteArticlePriceBuilder(ConcreteArticlePrice in){
            this.m = in;
        }

        @Override
        public ArticlePriceBuilder addPrice(Market market, double amount, String currency) {
            if(m.price == null)
                m.price = Lists.newArrayList();
            m.price.add(new PriceInfoInternal(market, amount, currency));
            return this;
        }

        @Override
        public ArticlePriceBuilder addOriginalPrice(Market market, double amount, String currency) {
            if(m.originalPrice == null)
                m.originalPrice = Lists.newArrayList();
            m.originalPrice.add(new PriceInfoInternal(market, amount, currency));
            return this;
        }

        @Override
        public ArticlePriceBuilder addShippingPrice(Market market, double amount, String currency) {
            if(m.shippingPrice == null)
                m.shippingPrice = Lists.newArrayList();
            m.shippingPrice.add(new PriceInfoInternal(market, amount, currency));
            return this;
        }

        @Override
        public ArticlePrice build() {
            return m;
        }

        @Override
        public ArticlePriceBuilder from(ArticlePrice in) {
            m = (ConcreteArticlePrice) in;
            return this;
        }
    }
}
