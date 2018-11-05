package com.salesmore.yak.integration.shopee.model.returns.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.common.ListResult;
import com.salesmore.yak.integration.shopee.model.common.ReturnDisputeReason;
import com.salesmore.yak.integration.shopee.model.common.ReturnReason;
import com.salesmore.yak.integration.shopee.model.common.ReturnStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class ReturnDetail implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * Image URLs of return.
     */
    private List<String> images;

    /**
     * Reason for return product.
     */
    private ReturnReason reason;

    /**
     * Reason that buyer provide.
     */
    @JsonProperty("text_reason")
    private String textReason;

    /**
     * The serial number of return.
     */
    private String returnsn;

    /**
     * Amount of the refund.
     */
    @JsonProperty("refund_amount")
    private float refundAmount;

    /**
     * Currency of the return.
     */
    private String currency;

    /**
     * The time of return create.
     */
    @JsonProperty("create_time")
    private Long createTime;

    /**
     * The time of modify return.
     */
    @JsonProperty("update_time")
    private Long updateTime;

    /**
     * Enumerated type that defines the current status of the return.
     */
    private ReturnStatus status;

    /**
     * The last time seller deal with this return.
     */
    @JsonProperty("due_date")
    private Long dueDate;

    /**
     * The tracking number assigned by the shipping carrier for item shipment.
     */
    @JsonProperty("tracking_number")
    private String trackingNumber;

    /**
     * The reason of seller dispute return. While the return has been disputed, this field is useful.
     */
    @JsonProperty("dispute_reason")
    private ReturnDisputeReason disputeReason;

    /**
     * The reason that seller provide. While the return has been disputed, this field is useful.
     */
    @JsonProperty("dispute_text_reason")
    private String disputeTextReason;

    /**
     * Items to be sent back to seller. Can be either integrated/non-integrated.
     */
    @JsonProperty("needs_logistics")
    private boolean needsLogistics;

    /**
     * Order price before discount.
     */
    @JsonProperty("amount_before_discount")
    private float amount_before_discount;

    @Data
    public static class User implements ModelEntity {

        public static final long serialVersionUID = 1L;

        /**
         * Buyer's nickname.
         */
        private Long username;

        /**
         * Buyer's email.
         */
        private String email;

        /**
         * Buyer's portrait.
         */
        private String portrait;
    }

    /**
     * Buyer Info
     */
    private User user;

    /**
     * List of Items
     */
    @JsonProperty("item")
    private List<ReturnItemDetail> items;

    /**
     * Shopee's unique identifier for an order.
     */
    private String ordersn;

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class ReturnDetails extends ListResult<ReturnDetail> {

        public static final long serialVersionUID = 1L;

        private List<ReturnDetail> returns;

        private boolean more;

        @Override
        protected List<ReturnDetail> value() {
            return returns;
        }

        @Override
        public boolean hasMore() {
            return more;
        }
    }
}
