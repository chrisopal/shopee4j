package com.salesmore.yak.integration.shopee.model.logistics.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.shopee.model.common.ListResult;
import com.salesmore.yak.integration.shopee.model.AddressBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Branch extends AddressBase {
	
	private static final long serialVersionUID = 1L;

    @JsonProperty("branch_id")
    private Long branchId;

    /**
     * The address description of specify address
     */
    private String address;

    @Data
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class Branches extends ListResult<Branch> {

        public static final long serialVersionUID = 1L;

        @JsonProperty("branch")
        private List<Branch> branches;


        @Override
        protected List<Branch> value() {
            return branches;
        }
    }
}
