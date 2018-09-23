package com.salesmore.yak.integration.shopee.model.logistics.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.shopee.model.logistics.response.internal.AirwayBill;
import lombok.Data;

import static com.salesmore.yak.integration.shopee.model.logistics.response.internal.AirwayBill.AirwayBills;

@Data
public class AirwayBillsResult implements ModelEntity {

    public static final long serialVersionUID = 1L;

    /**
     * This object contains the detailed breakdown for the result of this API call if the param is_batch is false.
     */
    @JsonProperty("result")
    private AirwayBills<AirwayBill> result;

    /**
     * This object contains the detailed breakdown for the result of this API call if the param is_batch is true.
     */
    @JsonProperty("batch_result")
    private AirwayBills<String> batchResult;

}
