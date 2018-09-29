package com.salesmore.yak.integration.shopee.service.domain;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.shopee.api.domain.DiscountService;
import com.salesmore.yak.integration.shopee.model.discount.request.*;
import com.salesmore.yak.integration.shopee.model.discount.response.DiscountActionResult;
import com.salesmore.yak.integration.shopee.model.discount.response.DiscountDetail;
import com.salesmore.yak.integration.shopee.model.discount.response.DiscountItemActionResult;
import com.salesmore.yak.integration.shopee.model.discount.response.DiscountResult;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.salesmore.yak.integration.shopee.constants.PathConstants.*;
import static com.salesmore.yak.integration.shopee.model.discount.response.DiscountSimpleInfo.DiscountSimpleInfoList;

public class DiscountServiceImpl extends BaseRestClientService implements DiscountService {

    @Override
    public DiscountResult addDiscount(Discount discount) {
        checkNotNull(discount);
        checkArgument(discount.getEndTime()-discount.getStartTime() > 60*60, "Discount End Time must be one hour later than start time");
        return post(DiscountResult.class, uri(DISCOUNT_ADD_RELATIVE_PATH)).entity(discount).executeWithErrorResponse();
    }

    @Override
    public DiscountResult addDiscountItems(DiscountItems discountItems) {
        checkNotNull(discountItems);
        checkNotNull(discountItems.getItems());
        return post(DiscountResult.class,uri(DISCOUNT_ITEM_ADD_RELATIVE_PATH)).entity(discountItems).executeWithErrorResponse();
    }

    @Override
    public DiscountActionResult deleteDiscount(DiscountIdRequest idRequest) {
        checkNotNull(idRequest);
        checkNotNull(idRequest.getId());
        return post(DiscountActionResult.class,uri(DISCOUNT_DELETE_RELATIVE_PATH)).entity(idRequest).execute();
    }

    @Override
    public DiscountItemActionResult deleteDiscountItem(DiscountItemIdRequest itemIdRequest) {
        checkNotNull(itemIdRequest);
        checkArgument(itemIdRequest.getId() != null && itemIdRequest.getDiscountId() != null);
        return post(DiscountItemActionResult.class,uri(DISCOUNT_ITEM_DELETE_RELATIVE_PATH)).entity(itemIdRequest).execute();

    }

    @Override
    public DiscountDetail getDiscountDetail(DiscountPaginationRequest paginationRequest) {
        checkNotNull(paginationRequest);
        return post(DiscountDetail.class,uri(DISCOUNT_GET_DETAIL_RELATIVE_PATH)).entity(paginationRequest).execute();
    }

    @Override
    public DiscountSimpleInfoList getDiscountList(DiscountPaginationRequest paginationRequest) {
        checkNotNull(paginationRequest);
        return post(DiscountSimpleInfoList.class, uri(DISCOUNT_GET_LIST_RELATIVE_PATH)).entity(paginationRequest).execute();
    }

    @Override
    public DiscountActionResult updateDiscount(Discount discount) {
        checkNotNull(discount);
        checkArgument(discount.getEndTime()-discount.getStartTime() > 60*60, "Discount End Time must be one hour later than start time");
        return post(DiscountActionResult.class, uri(DISCOUNT_UPDATE_RELATIVE_PATH)).entity(discount).executeWithErrorResponse();

    }

    @Override
    public DiscountActionResult updateDiscountItems(DiscountItems discountItems) {
        checkNotNull(discountItems);
        checkNotNull(discountItems.getItems());
        return post(DiscountActionResult.class, uri(DISCOUNT_ITEM_UPDATE_RELATIVE_PATH)).entity(discountItems).executeWithErrorResponse();

    }
}
