package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.model.discount.request.*;
import com.salesmore.yak.integration.shopee.model.discount.response.*;
import com.salesmore.yak.integration.shopee.model.item.Variation;
import com.salesmore.yak.integration.shopee.model.item.response.ItemSimpleInfo;
import com.salesmore.yak.integration.shopee.model.item.response.ItemsResult;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.salesmore.yak.integration.shopee.model.discount.request.DiscountPaginationRequest.Status;
import static org.testng.Assert.*;

public class DiscountServiceTest extends AbstractTest {

    private Long discountId;

    private static List<ItemSimpleInfo> items;

    static  {
        ItemsResult result = client().item().getItemList(paginationBaseRequest());
        items = result.getItems();
    }

	@Test
    void addDiscount() throws Exception {
		DiscountResult discountResult = client().discount().addDiscount(discount());
		logger.info("Add Discount Result: {}", discountResult);
		discountId = discountResult.getDiscountId();
		assertNotNull(discountResult.getDiscountId());
    }
	
	@Test
	void addDiscountItems() throws Exception {
		DiscountResult discountResult = client().discount().addDiscountItems(discountItems());
        logger.info("Add Discount Result: {}", discountResult);
        assertEquals(discountResult.getDiscountId(), discountId);
	}
	
	@Test
	void b_updateDiscount() throws Exception {
        DiscountActionResult discountResult = client().discount().updateDiscount(discountUpdate());
        logger.info("Update Discount Result: {}", discountResult);
        assertEquals(discountResult.getDiscountId(), discountId);
	}

	@Test
    void b_updateDiscountItems() throws Exception {
        DiscountActionResult discountResult = client().discount().updateDiscountItems(discountItems());
        logger.info("Update Discount Items Result: {}", discountResult);
        assertEquals(discountResult.getDiscountId(), discountId);
    }

    @Test
    void c_getDiscountDetail() throws Exception {
    	DiscountDetail discountDetail = client().discount().getDiscountDetail(discountPaginationRequestForDetail());
        logger.info("Get Discount Detail Result: {}", discountDetail);
        assertEquals(discountDetail.getDiscountId(), discountId);
    }

    @Test
    void c_getDiscountList() throws Exception {
        DiscountSimpleInfo.DiscountSimpleInfoList discountList = client().discount().getDiscountList(discountPaginationRequestForList());
        logger.info("Get Discount List Result: {}", discountList);
        assertTrue(discountList.getDiscount().size() > 0);
    }

    @Test
    void deleteDiscountItems() throws Exception {
        List<DiscountItem> discountItems = getDiscountItems(true);
        Long itemId = discountItems.get(0).getId();
        DiscountItemActionResult actionResult = client().discount().deleteDiscountItem(discountItemIdRequest(itemId, null));
        logger.info("Delete Discount Item Result: {}", actionResult);
        assertEquals(actionResult.getDiscountId(), discountId);
        assertEquals(actionResult.getItemId(), itemId);
    }

    @Test
    void deleteDiscountItemsWithVariation() throws Exception {
        List<DiscountItem> discountItems = getDiscountItems(false);
        DiscountItem discountItem = discountItems.get(0);
        Long variationId = discountItem.getVariations().get(0).getId();
        DiscountItemActionResult actionResult = client().discount().deleteDiscountItem(discountItemIdRequest(discountItem.getId(), variationId));
        logger.info("Delete Discount Item Result: {}", actionResult);
        assertEquals(actionResult.getDiscountId(), discountId);
        assertEquals(actionResult.getItemId(), discountItem.getId());
        assertEquals(actionResult.getVariationId(), variationId);
    }

    @Test
    void deleteDiscountX() throws Exception {
        DiscountActionResult actionResult = client().discount().deleteDiscount(discountIdRequest());
        logger.info("Delete Discount Result: {}", actionResult);
        assertEquals(actionResult.getDiscountId(), discountId);
    }


    private List<DiscountItem> getDiscountItems(boolean add) {
        List<DiscountItem> discountItems = new ArrayList<>();
        for(ItemSimpleInfo item : items) {
        	DiscountItem.DiscountItemBuilder builder = DiscountItem.builder().id(item.getId()).purchaseLimit(10L);
        	if( item.getVariations() != null && !item.getVariations().isEmpty() ) {
        		for(Variation variation : item.getVariations()) {
                    if(!add) {
                        builder.variation(DiscountVariation.builder().id(variation.getId()).promotionPrice(0.1f + Math.abs(variation.getPrice() - ThreadLocalRandom.current().nextFloat())).build());
                    }
        		}
        		discountItems.add(builder.build());
        	}else {
        	    if(add) {
                    DiscountItem discountItem = builder.promotionPrice(1 + ThreadLocalRandom.current().nextFloat() * 5).build();
                    if (!discountItems.contains(discountItem))
                        discountItems.add(discountItem);
                }
        	}
        }
        logger.info("Discount Items: {}", discountItems);
        return discountItems;
    }
    
    private Discount discount() {
    	
    	return Discount.builder().shopId(SHOP_ID)
    			.partnerId(PARTNER_ID)
    			.timestamp(System.currentTimeMillis()/1000)
    			.name("salesmore_discount_1")
    			.startTime(System.currentTimeMillis()/1000+60*60*30) // now + 30m
    			.endTime(System.currentTimeMillis()/1000+60*60*120) // start + 90m
    			.items(getDiscountItems(true))
    			.build();
    	
    }

    private Discount discountUpdate() {

        return Discount.builder().shopId(SHOP_ID)
        		.discountId(discountId)
                .partnerId(PARTNER_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .name("salesmore_discount_updated")
                .startTime(System.currentTimeMillis()/1000+60*60*40) // now + 30m
                .endTime(System.currentTimeMillis()/1000+60*60*100) // start + 70m
                .build();

    }

    private DiscountItems discountItems() {
	    return DiscountItems.builder().shopId(SHOP_ID)
                .partnerId(PARTNER_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .items(getDiscountItems(false))
                .discountId(discountId)
                .build();
    }

    private DiscountIdRequest discountIdRequest() {
	    return DiscountIdRequest.builder().id(discountId)
                .shopId(SHOP_ID)
                .partnerId(PARTNER_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .build();
    }

    private DiscountItemIdRequest discountItemIdRequest(Long itemId, Long variationId) {
        return DiscountItemIdRequest.builder().discountId(discountId)
                .id(itemId)
                .variationId(variationId)
                .timestamp(System.currentTimeMillis()/1000)
                .partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .build();
    }

    private DiscountPaginationRequest discountPaginationRequestForDetail() {
        return DiscountPaginationRequest.builder().discountId(discountId)
        		.partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .paginationEntriesPerPage(10L)
                .paginationOffset(0)
                .build();
    }
    
    private DiscountPaginationRequest discountPaginationRequestForList() {
        return DiscountPaginationRequest.builder().status(Status.ALL)
        		.partnerId(PARTNER_ID)
                .shopId(SHOP_ID)
                .timestamp(System.currentTimeMillis()/1000)
                .paginationEntriesPerPage(10L)
                .paginationOffset(0)
                .build();
    }
}
