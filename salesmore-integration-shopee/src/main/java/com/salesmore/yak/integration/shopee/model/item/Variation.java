package com.salesmore.yak.integration.shopee.model.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.core.service.ListResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Variation implements ModelEntity {

    private static final long serialVersionUID = 1L;

    /**
     * Shopee's unique identifier for a variation of an item.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("variation_id")
    private Long id;

    /**
     * A variation SKU (stock keeping unit) is an identifier defined by a seller.
     * It is only intended for the seller's use.
     */
    @JsonProperty("variation_sku")
    private String sku;

    /**
     * Name of the variation that belongs to the same item.
     * A seller can offer variations of the same item.
     */
    private String name;

    /**
     * The current price of the variation in the listing currency.
     * If item is in promotion, this value is discount price.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private float price;

    /**
     * The current stock quantity of the variation in the listing currency.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Long stock;

    public enum Status {
        MODEL_NORMAL, MODEL_DELETED;

        @JsonCreator
        public static Status forValue(String value) {
            if (value != null) {
                for (Status s : Status.values()) {
                    if (s.name().equals(value))
                        return s;
                }
            }
            return null;
        }

        @JsonValue
        public String value() {
            return name();
        }
    }

    /**
     * Enumerated type that defines the current status of the variation.
     * Applicable values: MODEL_NORMAL and MODEL_DELETED.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Status status;

    /**
     * Timestamp that indicates the date and time that the variation was created.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("create_time")
    private Long createTime;

    /**
     * Timestamp that indicates the last time that there was a change
     * in value of the variation, such as price/stock change.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("update_time")
    private Long updateTime;

    /**
     * The original price of the variation in the listing currency.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("original_price")
    private float originalPrice;

    /**
     * Unique identifier for an item.
     */
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("item_id")
    private Long itemId;

    @Data
    public static class Variations extends ListResult<Variation> {

        private static final long serialVersionUID = 1L;

        @JsonProperty("variations")
        private List<Variation> variations;

        @Override
        protected List<Variation> value() {
            return variations;
        }
    }
}