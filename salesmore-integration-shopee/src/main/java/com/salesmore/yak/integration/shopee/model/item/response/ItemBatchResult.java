package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.service.ListResult;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class ItemBatchResult extends ErrorResponse {

    public static final long serialVersionUID = 1L;

    /**
     * List of item_id which have been updated successfully.
     */
    List<String> modifications;

    /**
     * Information for failed batch updating.
     */
    List<ItemUpdateResult> failures;


    @Data
    public static class ItemUpdateResult {

        /**
         * Unique identifier for an item.
         */
        @JsonProperty("item_id")
        private Long id;

        /**
         * Error description
         */
        @JsonProperty("error_description")
        private String errorDescription;

    }

    @Data
    public static class ItemUpdateBatchesResult extends ListResult<ItemBatchResult> {

        private static final long serialVersionUID = 1L;

        @JsonProperty("batch_result")
        private List<ItemBatchResult> batchResults;

        /**
         * The identifier for an API request for error tracking
         */
        @JsonProperty("request_id")
        private String requestId;

        @Override
        protected List<ItemBatchResult> value() {
            return batchResults;
        }
    }

}
