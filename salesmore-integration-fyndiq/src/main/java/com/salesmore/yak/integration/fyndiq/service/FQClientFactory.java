package com.salesmore.yak.integration.fyndiq.service;

import com.salesmore.yak.integration.core.transport.Config;
import com.salesmore.yak.integration.fyndiq.api.FQClient;
import com.salesmore.yak.integration.fyndiq.api.client.IFQClientBuilder;
import com.salesmore.yak.integration.fyndiq.service.client.FQClientBuilder;

/**
 * Factory Helper class to instantiate new FQClient
 */
public class FQClientFactory {

    //Default
    private static final String DEFAULT_ENDPOINT = "https://merchants-api-sandbox.fyndiq.com/api/v1";

    /**
     * Get Client Builder to instantiate client
     *
     * @return Builder
     */
    public static IFQClientBuilder builder() {
        return new FQClientBuilder();
    }

    /**
     * Get New Client with merchantId & token
     *
     * @param merchantId merchantId
     * @param token      token
     * @return client
     */
    public static FQClient newClient(String merchantId, String token) {
        return newClient(merchantId, token, DEFAULT_ENDPOINT);
    }

    /**
     * Get New Client with merchantId, token & endpoint, this should be
     * the most common way to instantiate a client
     *
     * @param merchantId merchantId
     * @param token      token
     * @param endpoint   endpoint
     * @return client
     */
    public static FQClient newClient(String merchantId, String token, String endpoint) {
        return newClient(merchantId, token, endpoint, Config.DEFAULT);
    }

    /**
     * Get New Client with merchantId, token, endpoint and customized config
     *
     * @param merchantId merchantId
     * @param token      token
     * @param endpoint   endpoint
     * @param config     config
     * @return client
     */
    public static FQClient newClient(String merchantId, String token, String endpoint, Config config) {

        return builder().merchantId(merchantId)
                .token(token)
                .endpoint(endpoint)
                .withConfig(config)
                .authenticate();
    }
}
