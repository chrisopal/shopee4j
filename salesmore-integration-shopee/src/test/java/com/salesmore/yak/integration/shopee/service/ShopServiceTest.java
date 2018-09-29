package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.api.Builders;
import com.salesmore.yak.integration.shopee.model.BaseRequest;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopAuth;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopInfoUpdate;
import com.salesmore.yak.integration.shopee.model.shop.request.ShopInfoUpdate.ShopInfoUpdateBuilder;
import com.salesmore.yak.integration.shopee.model.shop.response.ShopInfo;
import com.salesmore.yak.integration.shopee.model.shop.response.ShopInfoUpdatedResult;

import com.salesmore.yak.integration.shopee.model.shop.response.ShopPerformance;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ShopServiceTest extends AbstractTest {
	
	@Test
	public void authShop() throws Exception {
		ShopAuth auth = Builders.shopAuth().id(PARTNER_ID).key(PARTNER_KEY).redirectUrl("https://www.baidu.com").build();
		client().shops().authorizeShop(auth);
		assertEquals(1, 1);
	}

    
    @Test
    public void updateShopInfo() throws Exception {
    	ShopInfoUpdatedResult result = client().shops().updateShopInfo(shopInfoUpdate());
    	logger.info("updated result: {}", result);
    	assertEquals(result.getShopName(), "uatsellercenter.sg");
    }

    @Test
    public void getShopInfo() throws Exception {
        ShopInfo shopInfo = client().shops().getShopInfo(client().baseRequest());
        logger.info(shopInfo.toString());
        assertEquals(SHOP_ID, shopInfo.getShopId());
    }

    @Test
	public void getShopPerformance() throws Exception {
		ShopPerformance performances = client().shops().getShopPerformance(client().baseRequest());
		logger.info("get Performance: {}", performances);
		assertNotNull(performances.getNonFulfillmentRate());

	}

    private ShopInfoUpdate shopInfoUpdate() {
    	BaseRequest baseRequest = client().baseRequest();
    	return ShopInfoUpdate.builder().timestamp(baseRequest.getTimestamp())
    			.shopId(baseRequest.getShopId())
    			.partnerId(baseRequest.getPartnerId())
    			.shopName("uatsellercenter.sg")
    			.shopDescription("This is a test shop with right ok")
    			.image("http://gtms01.alicdn.com/tps/i1/TB1wKlhFVXXXXcdaXXXEPxnHXXX-170-90.png")
    			.disableMakeOffer(0)
    			.enableDisplayUnitno(true)
    			.build();
    }
}
