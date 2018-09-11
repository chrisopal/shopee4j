package com.salesmore.yak.integration.core.api;

import com.salesmore.yak.integration.core.transport.HttpRequest;

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
     * Gets the token identifier with HttpRequest
     *
     * In cases Some times it needs the http request as content to generate the token
     *
     * @return the auth token identifier
     */
    <T> String getTokenId(HttpRequest<T> httpRequest);

    /**
     *
     * Gets the auth header name which varies
     *
     * @return the auth header Name
     */
    String getAuthHeaderName();

}
