package com.salesmore.yak.integration.core.api.exceptions;

/**
 * An exception which is thrown when a connection/IO exception has occurred with the remote host
 *
 */
public class ConnectionException extends ResponseException {

	private static final long serialVersionUID = 1L;

	public ConnectionException(String message, int status, Throwable cause) {
		super(message, status, cause);
	}

}
