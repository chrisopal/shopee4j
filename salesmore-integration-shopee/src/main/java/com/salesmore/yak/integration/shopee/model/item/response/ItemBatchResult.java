package com.salesmore.yak.integration.shopee.model.item.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.ObjectResult;
import com.salesmore.yak.integration.shopee.model.common.ListResult;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class ItemBatchResult {

    public static final long serialVersionUID = 1L;

    /**
     * List of item_id which have been updated successfully.
     */
    List<ItemIdResult> modifications;

    /**
     * Information for failed batch updating.
     */
    List<ItemUpdateResult> failures;

    @Data
    private static class ItemIdResult {

        /**
         * Unique item id identifier
         */
        @JsonProperty("item_id")
        private String itemId;
    }


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
    public static class ItemUpdateBatchesResult extends ObjectResult<ItemBatchResult> {

        private static final long serialVersionUID = 1L;

        @JsonProperty("batch_result")
        private ItemBatchResult batchResult;

        @Override
        protected ItemBatchResult value() {
            return batchResult;
        }
    }

}
