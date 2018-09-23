package com.salesmore.yak.integration.shopee.service;

import com.salesmore.yak.integration.shopee.utils.HashingUtils;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class HashingUtilsTest extends AbstractTest{
    
    @Test
    void encryptHmac256() throws Exception {
        String encoded = HashingUtils.hmacSHA256Digest("The quick brown fox jumps over the lazy dog", "key");
        logger.info(encoded);
        assertEquals(encoded, "f7bc83f430538424b13298e6aa6fb143ef4d59a14946175997479dbc2d1a3cd8");
    }
    
    @Test
    void encryptSHA256() throws Exception {
        String encoded = HashingUtils.sha256Hashing("f44262e6ef143ca4cff63d3f2a8dabfada3a5581abfbef7a8b52197da4148c9ahttp://www.baidu.com");
        logger.info(encoded);
        assertEquals(encoded, "e10143775ee389a1152e2a1cf75f3f8608c80f6429514cea527bc6fb1718d19a");
    }
}
