package com.salesmore.yak.integration.core.api;


import com.salesmore.yak.integration.core.api.exceptions.AuthenticationException;
import com.salesmore.yak.integration.core.transport.Config;

/**
 *
 * Common Rest Client Builder, different sdks can extends and implement the authenticate methods
 *
 * with specific parameters
 *
 * @param <R>  the actual client facade to play
 * @param <T>  the Builder
 */
public interface IRestClientBuilder<R, T extends IRestClientBuilder<R, T>> {

    /**
     * Associates the given configuration with this Client
     *
     * @param config Rest Client configuration options
     * @return self for method chaining
     */
    T withConfig(Config config);

    /**
     * The authentication credentials, this should be common for all rest api integration
     *
     * @param userId the user id to authenticate with
     * @param password the password to authenticate with
     * @return self for method chaining
     */
    T credentials(String userId, String password);

    /**
     * The service endpoint to connect to
     *
     * @param endpoint the endpoint URL of the service
     * @return self for method chaining
     */
    T endpoint(String endpoint);

    /**
     * The auth endpoint to connect to, could be different with service endpoint
     *
     * @param endpoint the auth endpoint URL of the service
     * @return self for method chaining
     */
    T authEndpoint(String endpoint);

    /**
     * Attempts to connect, authenticated and obtain an authorization access
     * entity which contains a token, As a response a client will be returned
     * with token obtained,
     *
     * OAuth2/Basic Auth/custom auth
     *
     * @return the authenticated client
     * @throws AuthenticationException if the credentials is
     *             invalid
     */
    R authenticate() throws AuthenticationException;

}
