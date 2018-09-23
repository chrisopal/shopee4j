package com.salesmore.yak.integration.shopee.model.item.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.item.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class Item extends BaseRequest {

    /**
     * Id of the Item
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("item_id")
    private Long id;
    /**
     * Should call shopee.item.GetCategories to get category first.
     * Related to result.categories.category_id
     */
    @JsonProperty("category_id")
    private Long categoryId;

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
     * The variation of item is to list out all models of this product
     */
    private List<Variation> variations;

    /**
     * mage URLs of the item. Up to 9 images,
     */
    @Singular
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Image> images;

    /**
     * attribute value list
     */
    @Singular
    private List<AttributeValue> attributes;

    /**
     * Should call shopee.logistics.GetLogistics to get logistics first. Should contain all all logistics.
     */
    @Singular
    private List<Logistic> logistics;

    /**
     * the net weight of this item, the unit is KG.
     */
    private float weight;

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
    @Singular
    private List<WholeSale> wholesales;
    /**
     * Url of size chart image. Only particular categories support it.
     */
    @JsonProperty("size_chart")
    private String sizeChart;

    /**
     * This indicates whether the item is secondhand.
     */
    private String condition;

}
