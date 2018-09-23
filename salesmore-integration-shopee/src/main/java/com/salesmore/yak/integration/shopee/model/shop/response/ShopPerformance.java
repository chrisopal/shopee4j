package com.salesmore.yak.integration.shopee.model.shop.response;

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

    /**
     * Threshold average_preparation_time
     *
     * Preparation time is the number of days it takes a seller to prepare and ship out an order.
     */
    @JsonProperty("average_preparation_time")
    private Threshold averagePreparationTime;

    /**
     * Threshold late_shipment_rate
     *
     * Late shipment rate is the percentage of orders (out of total orders) that were shipped late in the past 30 days.
     * You should maintain your late shipment rate at a healthy level of <5%.
     * If your late shipment rate exceeds 15%, you will receive a penalty point under the Seller Penalty Points system.
     */
    @JsonProperty("late_shipment_rate")
    private Threshold lateShipmentRate;

    /**
     * Threshold return_refund_rate
     *
     * Return-refund rate is the percentage of orders (out of total orders) that were requested
     * by buyers for a return-refund in the past 30 days.
     */
    @JsonProperty("return_refund_rate")
    private Threshold returnRefundRate;

    /**
     * Threshold response_time
     *
     * Chat response time is the average time it takes a seller to respond to a buyer's chat message.
     */
    @JsonProperty("response_time")
    private Threshold responseRime;

    /**
     * Threshold prohibited_listing_violation
     *
     * It is the responsibility of sellers to ensure all item listed under their profiles
     * are fully compliant with local laws, as well as Shopee’s terms and policies.
     */
    @JsonProperty("prohibited_listing_violation")
    private Threshold prohibitedListingViolation;

    /**
     * Threshold cancellation_rate
     *
     * Cancellation rate is the percentage of orders (out of total orders) cancelled
     * by a seller in the past 30 days. Buyers initiated cancellations are not included in the calculation.
     */
    @JsonProperty("cancellation_rate")
    private Threshold cancellationRate;

    /**
     * Threshold counterfeit_listing_violation
     *
     * Sellers should only list authentic products. Counterfeit item are products
     * that were made in exact imitation of an existing brand with the intention to deceive or defraud,
     * and may include, but are not limited to: - Products that are fake or replicas of an existing
     * official product - Products that have never been produced by a specific brand -
     * Products that bear such similarities with other products (e.g. a replica of a branded
     * item with or without altered logos) without the authorization of the trademark owner
     */
    @JsonProperty("counterfeit_listing_violation")
    private Threshold counterfeitListingViolation;

    /**
     * Threshold shop_rating
     *
     * Your shop rating
     */
    @JsonProperty("shop_rating")
    private Threshold shopRating;

    /**
     * Threshold response_rate
     *
     * Chat response rate is the percentage of new chats and offers (out of total) that a seller responds
     * to within 12 hours of receiving them. Auto replies are not included in the chat response rate computation.
     */
    @JsonProperty("response_rate")
    private Threshold response_rate;

    /**
     * Threshold non_fulfillment_rate
     *
     * Non-fulfilment rate is the percentage of orders (out of total orders) that were either cancelled
     * or returned in the past 30 days. Only orders cancelled by sellers are taken into consideration
     * when computing non-fulfilment rate. Non-fulfilment rate is also the sum of your cancellation
     * rate and return-refund rate.
     */
    @JsonProperty("non_fulfillment_rate")
    private Threshold nonFulfillmentRate;
}
