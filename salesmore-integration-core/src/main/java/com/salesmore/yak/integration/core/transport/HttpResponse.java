package com.salesmore.yak.integration.core.transport;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Map;

/**
 * Wraps a Response from the Underlined Http Client
 *
 */
public interface HttpResponse extends Closeable {

	/**
	 * Gets the entity and Maps any errors which will result in a ResponseBaseException
	 *
	 * @param <T> the generic type
	 * @param returnType the return type
	 * @return the entity
	 */
	<T> T getEntity(Class<T> returnType);
	
	/**
	 * Reads the entity as is into the specified type without any exceptions mapping
	 * 
	 * @param typeToReadAs the type to read the desired entity in as
	 * @return the entity
	 */
	<T> T readEntity(Class<T> typeToReadAs);

	/**
	 * Gets the status from the previous Request
	 *
	 * @return the status code
	 */
	int getStatus();
	
	/**
	 * The current content-type within the response
	 * 
	 * @return the response content-type
	 */
	String getContentType();
	
	/**
	 * The status message which is associated with the current {@link #getStatus()}
	 * @return the status message or null
	 */
	String getStatusMessage();

	/**
	 * @return the input stream
	 */
	InputStream getInputStream();

	/**
	 * The response string for detailed error description in case of failure
	 *
	 * @return response as string
	 */
	String responseAsString();

	/**
	 * Returns a Header value from the specified name key
	 *
	 * @param name the name of the header to query for
	 * @return the header as a String or null if not found
	 */
	String header(String name);

	/**
	 * @return the a Map of Header Name to Header Value
	 */
	Map<String, String> headers();
}
