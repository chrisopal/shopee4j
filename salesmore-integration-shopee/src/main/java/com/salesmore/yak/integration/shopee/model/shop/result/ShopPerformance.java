package com.salesmore.yak.integration.shopee.model.shop.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.shop.Threshold;
import lombok.Data;


@Data
public class ShopPerformance implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Threshold spam_listing_violation
     *
     * To ensure that buyers can easily find what they are looking for,
     * any attempts by sellers to manipulate search results to gain an unfair advantage will be penalized.
     */
    @JsonProperty("spam_listing_violation")
    private Threshold spamListingViolation;


    /**
     * Threshold overall_review_rating
     *
     * Overall review rating is the average of all order ratings submitted by your buyers.
     */
    @JsonProperty("overall_review_rating")
    private Threshold overallReviewRating;
}
