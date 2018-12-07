package com.salesmore.yak.integration.fyndiq.service.articles.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.salesmore.yak.integration.fyndiq.model.articles.*;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.ArticleCreateBuilder;

import java.util.List;

/**
 * ArticleCreate Implementation
 */
public class ArticleConcreteCreate implements ArticleCreate {

    public static final long serialVersionUID = 1L;

    private String sku;
    @JsonProperty("parent_sku")
    private String parentSku;

    private Status status;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int quantity;
    private String color;
    private String size;
    private String brand;
    private List<String> tags;
    private String gtin;
    @JsonProperty("main_image")
    private String mainImage;
    private List<String> images;
    private List<Market> markets;
    private List<Language> title;
    private List<Language> description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<? extends PriceInfo> price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("original_price")
    private List<? extends PriceInfo> originalPrice;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("shipping_price")
    private List<? extends PriceInfo> shippingPrice;

    @JsonProperty("shipping_time")
    private List<ShippingTimeInfo> shippingTime;

    public static ArticleCreateBuilder builder(){
        return new ArticleCreateConcreteBuilder();
    }

    @Override
    public ArticleCreateBuilder toBuilder() {
        return new ArticleCreateConcreteBuilder(this);
    }

    @Override
    public String getSku() {
        return sku;
    }

    @Override
    public String getParentSku() {
        return parentSku;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getGtin() {
        return gtin;
    }

    @Override
    public String getMainImage() {
        return mainImage;
    }

    @Override
    public List<String> getImages() {
        return images;
    }

    @Override
    public List<Market> getMarkets() {
        return markets;
    }

    @Override
    public List<Language> getTitle() {
        return title;
    }

    @Override
    public List<Language> getDescription() {
        return description;
    }

    @Override
    public List<? extends PriceInfo> getPrice() {
        return price;
    }

    @Override
    public List<? extends PriceInfo> getOriginalPrice() {
        return originalPrice;
    }

    @Override
    public List<? extends PriceInfo> getShippingPrice() {
        return shippingPrice;
    }

    @Override
    public List<? extends ShippingTimeInfo> getShippingTime() {
        return shippingTime;
    }

    //make all the fields of ArticleConcreteCreate accessible for builder class
    public static class ArticleCreateConcreteBuilder implements ArticleCreateBuilder{

        ArticleConcreteCreate m;

        ArticleCreateConcreteBuilder() {
            this(new ArticleConcreteCreate());
        }

        ArticleCreateConcreteBuilder(ArticleConcreteCreate c){
            this.m = c;
        }

        @Override
        public ArticleCreateBuilder sku(String sku) {
            m.sku = sku;
            return this;
        }

        @Override
        public ArticleCreateBuilder parentSku(String parentSku) {
            m.parentSku = parentSku;
            return this;
        }

        @Override
        public ArticleCreateBuilder status(Status status) {
            m.status = status;
            return this;
        }

        @Override
        public ArticleCreateBuilder quantity(int quantity) {
            m.quantity = quantity;
            return this;
        }

        @Override
        public ArticleCreateBuilder tags(List<String> tags) {
            m.tags = tags;
            return this;
        }

        @Override
        public ArticleCreateBuilder addTag(String tag) {
            if( m.tags == null )
                m.tags = Lists.newArrayList();

            m.tags.add(tag);
            return this;
        }

        @Override
        public ArticleCreateBuilder size(String size) {
            m.size = size;
            return this;
        }

        @Override
        public ArticleCreateBuilder brand(String brand) {
            m.brand = brand;
            return this;
        }

        @Override
        public ArticleCreateBuilder gtin(String gtin) {
            m.gtin = gtin;
            return this;
        }

        @Override
        public ArticleCreateBuilder color(String color) {
            m.color = color;
            return this;
        }

        @Override
        public ArticleCreateBuilder mainImage(String mainImage) {
            m.mainImage = mainImage;
            return this;
        }

        @Override
        public ArticleCreateBuilder images(List<String> images) {
            m.images = images;
            return this;
        }

        @Override
        public ArticleCreateBuilder addImage(String image) {
            if( m.images == null )
                m.images = Lists.newArrayList();
            m.images.add(image);
            return this;
        }

        @Override
        public ArticleCreateBuilder markets(List<Market> markets) {
            m.markets = markets;
            return this;
        }

        @Override
        public ArticleCreateBuilder addMarket(Market market) {
            if( m.markets == null )
                m.markets = Lists.newArrayList();

            m.markets.add(market);
            return this;
        }

        @Override
        public ArticleCreateBuilder titles(List<Language> title) {
            m.title = title;
            return this;
        }

        @Override
        public ArticleCreateBuilder addTitle(String language, String value) {
            if(m.title == null)
                m.title = Lists.newArrayList();

            m.title.add(new Language(language, value));
            return this;
        }

        @Override
        public ArticleCreateBuilder descriptions(List<Language> description) {
            m.description = description;
            return this;
        }

        @Override
        public ArticleCreateBuilder addDescription(String language, String value) {
            if( m.description == null )
                m.description = Lists.newArrayList();

            m.description.add(new Language(language, value));
            return this;
        }

        @Override
        public ArticleCreateBuilder addArticlePrice(ArticlePrice articlePrice) {

            m.price = articlePrice.getPrice();
            m.originalPrice = articlePrice.getOriginalPrice();
            m.shippingPrice = articlePrice.getShippingPrice();
            return this;
        }

        @Override
        public ArticleCreateBuilder shippingTime(List<ShippingTimeInfo> list) {
            m.shippingTime = list;
            return this;
        }

        @Override
        public ArticleCreateBuilder addShippingTime(Market market, String time) {
            if(m.shippingTime == null)
                m.shippingTime = Lists.newArrayList();

            m.shippingTime.add(new ShippingTimeInfo(market, time));
            return this;
        }

        @Override
        public ArticleCreate build() {
            return m;
        }

        @Override
        public ArticleCreateBuilder from(ArticleCreate in) {
             m = (ArticleConcreteCreate)in;
             return this;
        }


    }
}
