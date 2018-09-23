package com.salesmore.yak.integration.core.transport;

import com.salesmore.yak.integration.core.api.exceptions.AuthenticationException;
import com.salesmore.yak.integration.core.api.exceptions.ClientResponseException;
import com.salesmore.yak.integration.core.api.exceptions.ResponseException;
import com.salesmore.yak.integration.core.api.exceptions.ServerResponseException;
import com.salesmore.yak.integration.core.model.ErrorBaseResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * Exception Handles for common Http messages and status codes
 *
 */
public class HttpExceptionHandler {

    /**
     * Maps an Exception based on the underlying status code
     *
     * @param message the message
     * @param status the status
     * @return the response exceptions
     */
    public static ResponseException mapException(String message, int status) {

        return mapException(message, status, null);
    }

    /**
     * Maps an Exception based on the underlying status code
     *
     * @param message the message
     * @param status the status
     * @param cause the cause
     * @return the response exceptions
     */
    public static ResponseException mapException(String message, int status, Throwable cause) {
        if (status == 401)
            return new AuthenticationException(message, status, cause);
        if (status >= 400 && status < 499)
            return new ClientResponseException(message, status, cause);
        if (status >= 500 && status < 600)
            return new ServerResponseException(message, status, cause);

        return new ResponseException(message, status, cause);
    }


    /**
     * Maps an Exception based on the error response entity
     *
     * @param errorBaseResponse error response
     * @return the response exceptions
     */
    public static ResponseException mapException(ErrorBaseResponse errorBaseResponse) {
        return new ResponseException(StringUtils.isEmpty(errorBaseResponse.getMsg()) ? String.format("%s:%s", errorBaseResponse.getError().code(), errorBaseResponse.getError().description()) : errorBaseResponse.getMsg(), 500 );
    }
    
}
