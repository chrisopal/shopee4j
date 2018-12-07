package com.salesmore.yak.integration.fyndiq.model.identity;


/**
 * Base Auth Entity that could be extend and implement by future client
 * authentication and authorization method, like basic, OAUTH2
 *
 */
public interface AuthStore {

    /**
     * @return the username used to authenticate
     */
    String getUsername();

    /**
     * @return the password used to authenticate
     */
    String getPassword();

    /**
     *
     * @return the identifier of the client
     */
    String getId();

    /**
     *
     * @return additional name identifier
     */
    String getName();
}
