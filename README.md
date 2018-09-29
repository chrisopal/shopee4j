shopee4j
===========
Shopee4J is a fluent Java client for [Shopee Open Platform](https://open.shopee.com/).  

Configure Lombok 
-----
* Download lombok version 1.18.2 or later and configure it for [Eclipse](https://projectlombok.org/setup/eclipse)
* Because in this project some of the experimental features like @Superbuilder are used, Intellij IDEA Lombok plugin is not suppoerted
  which will show some errors in Editor, but complie and running with no error.

Maven
-----

**Using Shopee4J with the OkHttp Connector with 1.0.0-Snapshot**

```xml
<dependency>
    <groupId>com.salesmore.yak</groupId>
    <artifactId>salesmore-integration-shopee</artifactId>
    <version>${project.version}</version>
</dependency>
```

Quick Usage Guide
-----------------

Below are some examples of the API usage.

#### New Client: 
```Java
//Client Example
    protected static final String TEST_SERVER_ENDPOINT = "https://partner.uat.shopeemobile.com/api/v1";
    protected static final long PARTNER_ID = 100421;
    protected static final String PARTNER_KEY = "f44262e6ef143ca4cff63d3f2a8dabfada3a5581abfbef7a8b52197da4148c9a";
    protected static final long SHOP_ID = 205753;
    private static final ShopeeClient shopeeClient = ShopeeClientFactory.newClient(PARTNER_ID, PARTNER_KEY, SHOP_ID, TEST_SERVER_ENDPOINT);
    
```
#### Get Service and API call
```java
//Build Request
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
      
//Init Api Call
ShopInfoUpdatedResult result = client().shops().updateShopInfo(shopInfoUpdate());
    	logger.info("updated result: {}", result);
    	assertEquals(result.getShopName(), "uatsellercenter.sg");
```
