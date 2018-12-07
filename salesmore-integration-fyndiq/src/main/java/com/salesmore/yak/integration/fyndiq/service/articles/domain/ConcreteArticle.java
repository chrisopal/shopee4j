package com.salesmore.yak.integration.fyndiq.service.articles.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.fyndiq.model.articles.*;

import java.util.List;

/**
 *
 * Article Implementation
 */
public class ConcreteArticle implements Article {

    public static final long serialVersionUID = 1L;


    private String id;
    @JsonProperty("product_id")
    private String productId;
    private String sku;
    @JsonProperty("parent_sku")
    private String parentSku;
    @JsonProperty("fyndiq_status")
    private String fyndiqStatus;

    @JsonProperty("fyndiq_reasons")
    private List<String> fyndiqReasons;
    @JsonProperty("merchant_id")
    private String merchantId;

    private Status status;
    private int quantity;

    private List<PropertyPair> properties;

    private String brand;
    private List<String> tags;
    private String gtin;
    @JsonProperty("main_image")
    private String mainImage;
    private List<String> images;
    private List<Market> markets;
    private List<Language> title;
    private List<Language> description;
    private List<PriceInfoInternal> price;
    @JsonProperty("original_price")
    private List<PriceInfoInternal> originalPrice;

    @JsonProperty("shipping_price")
    private List<PriceInfoInternal> shippingPrice;
    @JsonProperty("shipping_time")
    private List<ShippingTimeInfo> shippingTime;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getProductId() {
        return this.productId;
    }

    @Override
    public String getMerchantId() {
        return this.merchantId;
    }

    @Override
    public String getFyndiqStatus() {
        return this.fyndiqStatus;
    }

    @Override
    public List<String> getFyndiqReasons() {
        return this.fyndiqReasons;
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
    public int getQuantity() {
        return quantity;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    @Override
    public List<PropertyPair> getProperties() {
        return this.properties;
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
    public List<? extends PriceInfoInternal> getPrice() {
        return price;
    }

    @Override
    public List<? extends PriceInfoInternal> getOriginalPrice() {
        return originalPrice;
    }

    @Override
    public List<? extends PriceInfoInternal> getShippingPrice() {
        return shippingPrice;
    }

    @Override
    public List<? extends ShippingTimeInfo> getShippingTime() {
        return shippingTime;
    }

    @Override
    public String toString() {
        return "ConcreteArticle{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", sku='" + sku + '\'' +
                ", parentSku='" + parentSku + '\'' +
                ", fyndiqStatus='" + fyndiqStatus + '\'' +
                ", fyndiqReasons=" + fyndiqReasons +
                ", merchantId='" + merchantId + '\'' +
                ", status=" + status +
                ", quantity=" + quantity +
                ", properties=" + properties +
                ", brand='" + brand + '\'' +
                ", tags=" + tags +
                ", gtin='" + gtin + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", images=" + images +
                ", markets=" + markets +
                ", title=" + title +
                ", description=" + description +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", shippingPrice=" + shippingPrice +
                ", shippingTime=" + shippingTime +
                '}';
    }
}
