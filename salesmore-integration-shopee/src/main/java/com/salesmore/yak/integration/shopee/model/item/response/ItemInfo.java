package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.item.*;
import lombok.Data;

import java.util.List;

@Data
public class ItemInfo implements ModelEntity {

    private static final long serialVersionUID = 1L;

    @JsonProperty("item_id")
    private Long id;

    /**
     * shop id of the item
     */
    @JsonProperty("shopid")
    private Long shopId;
    /**
     * Name of the item in local language.
     */
    private String name;

    /**
     * Description of the item in local language.
     */
    private String description;

    /**
     * The current price of the item in the listing currency.
     */
    private float price;

    /**
     * The current stock quantity of the item.
     */
    private Long stock;

    /**
     * An item SKU (stock keeping unit) is an identifier defined by a seller,
     * sometimes called parent SKU.
     */
    @JsonProperty("item_sku")
    private String itemSku;

    /**
     * Item Status
     */
    private ItemStatus status;
    /**
     * This is to indicate whether the item has variation(s).
     */
    @JsonProperty("has_variation")
    private boolean hasVariation;

    /**
     * Image URLs of the item. It contains at most 9 URLs.
     */
    private List<String> images;

    /**
     * The three-digit code representing the currency unit used for the item in Shopee Listings.
     */
    private String currency;

    /**
     * Timestamp that indicates the date and time that the item was created.
     */
    @JsonProperty("create_time")
    private Long createTime;

    /**
     * Timestamp that indicates the last time that there was a change
     * in value of the item, such as price/stock change.
     */
    @JsonProperty("update_time")
    private Long updateTime;

    /**
     * the net weight of this item, the unit is KG.
     */
    private float weight;

    /**
     * Should call shopee.item.GetCategories to get category first.
     * Related to result.categories.category_id
     */
    @JsonProperty("category_id")
    private Long categoryId;

    /**
     * The original price of the item in the listing currency.
     */
    @JsonProperty("original_price")
    private float originalPrice;

    /**
     * The variation of item is to list out all models of this product
     */
    private List<Variation> variations;

    /**
     * Attributes
     */
    List<Attribute> attributes;

    /**
     * Logistics
     */
    private List<Logistic> logistics;

    /**
     * The length of package for this single item, the unit is CM
     */
    @JsonProperty("package_length")
    private long packageLength;

    /**
     * The width of package for this single item, the unit is CM
     */
    @JsonProperty("package_width")
    private long packageWidth;

    /**
     * The height of package for this single item, the unit is CM
     */
    @JsonProperty("package_height")
    private long packageHeight;

    /**
     *
     */
    @JsonProperty("days_to_ship")
    private long daysToShip;

    /**
     * The wholesales tier list. Please put the wholesale tier info in order by min count.
     */
    private List<WholeSale> wholesales;

    /**
     * The sales volume of item.
     */
    private long sales;

    /**
     * The conllection number of item.
     */
    private long likes;

    /**
     * The page view of item.
     */
    private long views;

    /**
     * Number of comments
     */
    @JsonProperty("cmt_count")
    private long comments;

    /**
     * The rating star scores of this item.
     */
    @JsonProperty("rating_star")
    private float ratingStar;

    /**
     * This indicates whether the item is secondhand.
     */
    private String condition;

    /**
     * The id of discount activity the item is currently in.
     * One item can only have one discount at a time.
     */
    private Long discountId;

    /**
     * The identifier for an API request for error tracking
     */
    @JsonProperty("request_id")
    private String requestId;

}
