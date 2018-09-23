package com.salesmore.yak.integration.shopee.model.logistics.request.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dropoff implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * The identity of branch. Retrieved from shopee.logistics.GetBranch branch.
     */
    @JsonProperty("branch_id")
    private Long branchId;

    /**
     * The real name of sender.
     */
    @JsonProperty("sender_real_name")
    private String senderRealName;

    /**
     * The tracking number assigned by the shipping carrier for item shipment.
     */
    @JsonProperty("tracking_no")
    private String trackingNo;
}
