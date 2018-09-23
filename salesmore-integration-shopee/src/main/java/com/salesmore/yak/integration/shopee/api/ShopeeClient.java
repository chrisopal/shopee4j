package com.salesmore.yak.integration.shopee.api;

import com.salesmore.yak.integration.core.api.AbstractRestClient;
import com.salesmore.yak.integration.shopee.api.domain.*;
import com.salesmore.yak.integration.shopee.model.BaseRequest;


/**
 *
 * Shopee Client to expose all operations
 *
 */
public interface ShopeeClient extends AbstractRestClient<ShopeeClient> {

	/**
	 * Get Base Request That required by all requests
	 * 
	 * @return base request
	 */
	BaseRequest baseRequest();
    /**
     * Shops Service API
     *
     * @return Shop service
     */
    ShopService shops();

	/**
	 * Shop Category
	 *
	 * @return shop category service
	 */
	ShopCategoryService shopCategory();

	/**
	 * Shop Item
	 *
	 * @return shop item service
	 */
	ItemService item();

	/**
	 * Image
	 *
	 * @return image service
	 */
	ImageService image();

    /**
     * Discount
     *
     * @return discount service
     */
	DiscountService discount();

    /**
     * Order
     *
     * @return order service
     */
	OrderService order();

	/**
	 * Logistics
	 *
	 * @return Logistics service
	 */
	LogisticsService logistics();

    /**
     * Returns
     *
     * @return returns service
     */
	ReturnsService returns();
}
