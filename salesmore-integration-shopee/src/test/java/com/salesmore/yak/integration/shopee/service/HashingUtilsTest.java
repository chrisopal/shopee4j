package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.utils.HashingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class HashingUtilsTest extends AbstractTest{

    private static final Logger logger = LoggerFactory.getLogger(HashingUtilsTest.class);
    
    @Test
    void encryptHmac256() throws Exception {
        String encoded = HashingUtils.hmacSHA256Digest("https://partner.shopeemobile.com/api/v1/orders/detail|{\"ordersn\": \"160726152598865\", \"shopid\": 61299, \"partner_id\": 1, \"timestamp\": 1470198856} ", "key");
        logger.info(encoded);
        assertEquals(encoded, "804539de4af1821e6afad8cbcbdf3014ca1f46e4096ea800604e911dbcaf72cf");
    }
    
    @Test
    void encryptSHA256() throws Exception {
        String encoded = HashingUtils.sha256Hashing("9b754aba01a5d719cc70c57782941ae6ff90fcc687282908ee480a364901d181https://www.google.com");
        logger.info(encoded);
        assertEquals(encoded, "815d97b3a582e2e39957545a0c8c3da63d2466b902a32956ddd7a784badccdb8");
    }
}
