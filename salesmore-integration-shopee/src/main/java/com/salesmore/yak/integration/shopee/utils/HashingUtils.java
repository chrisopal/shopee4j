package com.salesmore.yak.integration.shopee.utils;

import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class HashingUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashingUtils.class);

    /**
     * Enum types for
     */
    public static enum HMAlgorithm {
        HmacMD5, HmacSHA1, HmacSHA256
    }

    /**
     * Get HmacSHA 256 string
     *
     * @param msg original message
     * @param key signature key
     * @return Encrypt hmac sha256 string in hex
     */
    public static String hmacSHA256Digest(String msg, String key) {
        return hmacDigest(msg, key, HMAlgorithm.HmacSHA256.name());
    }

    public static String hmacDigest(String msg, String keyString, String algorithm) {
    	Formatter formatter = null;
    	try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes(StandardCharsets.UTF_8), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes(StandardCharsets.US_ASCII));
            formatter = new Formatter();
            for (byte b : bytes) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            LOGGER.error("Error while get hmac Digest: {}", e.getLocalizedMessage());
        }finally {
			if(formatter != null)
				formatter.close();
		}
        return null;
    }

    public static String sha256Hashing(String originalString) {
        return Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();
    }
}
