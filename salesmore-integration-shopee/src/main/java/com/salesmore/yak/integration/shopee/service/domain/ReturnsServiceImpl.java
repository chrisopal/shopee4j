package com.salesmore.yak.integration.shopee.service.domain;


import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.shopee.api.domain.ReturnsService;
import com.salesmore.yak.integration.shopee.model.returns.request.ReturnDisputeRequest;
import com.salesmore.yak.integration.shopee.model.returns.request.ReturnsIdRequest;
import com.salesmore.yak.integration.shopee.model.returns.request.ReturnsPaginationRequest;
import com.salesmore.yak.integration.shopee.model.returns.response.ReturnActionResult;
import com.salesmore.yak.integration.shopee.model.returns.response.ReturnDetail;
import org.apache.commons.lang3.StringUtils;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.salesmore.yak.integration.shopee.constants.PathConstants.RETURNS_CONFIRM_RELATIVE_PATH;
import static com.salesmore.yak.integration.shopee.constants.PathConstants.RETURNS_DISPUTE_RELATIVE_PATH;
import static com.salesmore.yak.integration.shopee.constants.PathConstants.RETURNS_GET_LIST_RELATIVE_PATH;

public class ReturnsServiceImpl extends BaseRestClientService implements ReturnsService {

    @Override
    public ReturnActionResult confirmReturn(ReturnsIdRequest idRequest) {
        checkNotNull(idRequest);
        checkNotNull(idRequest.getReturnsn());
        return post(ReturnActionResult.class, uri(RETURNS_CONFIRM_RELATIVE_PATH)).entity(idRequest).executeWithErrorResponse();
    }

    @Override
    public ReturnActionResult disputeReturn(ReturnDisputeRequest disputeRequest) {
        checkNotNull(disputeRequest);
        checkArgument(!StringUtils.isEmpty(disputeRequest.getReturnsn()) && disputeRequest.getDisputeReason() != null);
        return post(ReturnActionResult.class, uri(RETURNS_DISPUTE_RELATIVE_PATH)).entity(disputeRequest).executeWithErrorResponse();
    }

    @Override
    public ReturnDetail.ReturnDetails getReturnList(ReturnsPaginationRequest query) {
        checkNotNull(query);
        return post(ReturnDetail.ReturnDetails.class, uri(RETURNS_GET_LIST_RELATIVE_PATH)).entity(query).executeWithErrorResponse();

    }
}
