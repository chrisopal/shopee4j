package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.ObjectResult;
import com.salesmore.yak.integration.shopee.model.common.ListResult;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class VariationBatchResult {

    public static final long serialVersionUID = 1L;

    /**
     * List of item_id which have been updated successfully.
     */
    List<VariationResult> modifications;

    /**
     * Informations for failed price updating.
     */
    List<VariationResult> failures;


    @Data
    public static class VariationResult {

        /**
         * Unique identifier for an item.
         */
        @JsonProperty("item_id")
        private Long id;

        /**
         * Shopee's unique identifier for a variation of an item.
         */
        @JsonProperty("variation_id")
        private Long variationId;

        /**
         * Error description
         */
        @JsonProperty("error_description")
        private String errorDescription;

    }

    @Data
    public static class VariationBatchesResult extends ObjectResult<VariationBatchResult> {

        private static final long serialVersionUID = 1L;

        @JsonProperty("batch_result")
        private VariationBatchResult batchResult;

        @Override
        protected VariationBatchResult value() {
            return batchResult;
        }
    }

}
