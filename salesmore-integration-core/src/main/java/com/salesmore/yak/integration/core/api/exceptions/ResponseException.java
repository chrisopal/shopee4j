package com.salesmore.yak.integration.core.api.exceptions;


import com.google.common.base.MoreObjects;

public class ResponseException extends RestClientBaseException {

    private static final long serialVersionUID = 7294957362769575271L;

    protected int status;

    public ResponseException(String message, int status) {
        super(message);
        this.status = status;
    }

    public ResponseException(String message, int status, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    /**
     * @return the raw status code
     */
    public int getStatus() {
        return status;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("message", getMessage()).add("status", getStatus())
                .toString();
    }

    /**
     * Maps an Exception based on the underlying status code
     *
     * @param message the message
     * @param status the status
     * @return the response exception
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
     * @return the response exception
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

}

