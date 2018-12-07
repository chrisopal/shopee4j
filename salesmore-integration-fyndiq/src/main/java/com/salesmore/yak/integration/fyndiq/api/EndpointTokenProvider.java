package com.salesmore.yak.integration.fyndiq.api;

public interface EndpointTokenProvider {
    /**
     * Gets the endpoint
     *
     * @return the endpoint
     */
    String getEndpoint();

    /**
     * Gets the token identifier
     *
     * @return the auth token identifier
     */
    String getTokenId();

    /**
     *
     * Gets the auth header name which varies
     *
     * @return the auth header Name
     */
    String getAuthHeaderName();

}
