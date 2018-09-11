package com.salesmore.yak.integration.core.api.exceptions;

/**
 * An exception that is thrown when Credentials failed or the default tenant is invalid
 *
 */
public class AuthenticationException extends ResponseException {

	private static final long serialVersionUID = 1L;

	public AuthenticationException(String message, int status, Throwable cause) {
		super(message, status, cause);
	}

	public AuthenticationException(String message, int status) {
		super(message, status);
	}

}
