package com.salesmore.yak.integration.shopee.api.domain;

import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.shopee.model.discount.request.*;
import com.salesmore.yak.integration.shopee.model.discount.response.*;

import java.util.List;

public interface DiscountService extends RestService {

    /**
     * Add Discount
     *
     * @param discount to add
     * @return discount result
     */
    DiscountResult addDiscount(Discount discount);

    /**
     * Add Discount Items
     *
     * @param discountItems to add
     * @return result
     */
    DiscountResult addDiscountItems(DiscountItems discountItems);

    /**
     * Delete Discount
     *
     * @param idRequest discount id
     * @return action result
     */
    DiscountActionResult deleteDiscount(DiscountIdRequest idRequest);

    /**
     * Delete Discount Item
     *
     * @param itemIdRequest discount item id
     * @return action result
     */
    DiscountItemActionResult deleteDiscountItem(DiscountItemIdRequest itemIdRequest);

    /**
     * Get Discount Detail
     *
     * @param paginationRequest query
     * @return discount detail
     */
    DiscountDetail getDiscountDetail(DiscountPaginationRequest paginationRequest);

    /**
     * Get Simplified Discount List
     *
     * @param paginationRequest query
     * @return list of discount simple info
     */
    DiscountSimpleInfo.DiscountSimpleInfoList getDiscountList(DiscountPaginationRequest paginationRequest);

    /**
     * Update Discount
     *
     * @param discount to update
     * @return discount action result
     */
    DiscountActionResult updateDiscount(Discount discount);

    /**
     * Update Discount Items
     *
     * @param discountItems to update
     * @return result
     */
    DiscountActionResult updateDiscountItems(DiscountItems discountItems);
}
