package com.salesmore.yak.integration.core.api.exceptions;

/**
 * Exception that is thrown when the user hasn't included the desired Rest Client connector within their classpath
 *
 */
public class ConnectorNotFoundException extends RestClientBaseException {

    private static final long serialVersionUID = 1L;

    public ConnectorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectorNotFoundException(String message) {
        super(message);
    }

}
