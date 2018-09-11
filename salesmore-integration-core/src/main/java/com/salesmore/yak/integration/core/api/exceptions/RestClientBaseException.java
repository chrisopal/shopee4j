package com.salesmore.yak.integration.core.api.exceptions;


/**
 * Base Rest Client Exception
 *
 */
public class RestClientBaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RestClientBaseException(String message) {
        super(message);
    }

    public RestClientBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestClientBaseException(Throwable cause) {
        super(cause);
    }
}
