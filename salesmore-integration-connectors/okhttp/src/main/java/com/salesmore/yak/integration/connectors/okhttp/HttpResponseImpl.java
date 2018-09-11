package com.salesmore.yak.integration.connectors.okhttp;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.salesmore.yak.integration.core.api.exceptions.ClientResponseException;
import com.salesmore.yak.integration.core.constants.ClientConstants;
import com.salesmore.yak.integration.core.transport.HttpEntityHandler;
import com.salesmore.yak.integration.core.transport.HttpResponse;
import com.salesmore.yak.integration.core.transport.ObjectMapperSingleton;
import okhttp3.Headers;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpResponseImpl implements HttpResponse {

    private static final Logger LOG = LoggerFactory.getLogger(HttpResponseImpl.class);
    private final Response response;

    private HttpResponseImpl(Response response) {
        this.response = response;
    }

    /**
     * Wrap the given Response
     *
     * @param response the response
     * @return the HttpResponse
     */
    public static HttpResponseImpl wrap(Response response) {
        return new HttpResponseImpl(response);
    }

    /**
     * Unwrap and return the original Response
     *
     * @return the response
     */
    public Response unwrap() {
        return response;
    }

    /**
     * Gets the entity and Maps any errors which will result in a ResponseException
     *
     * @param <T> the generic type
     * @param returnType the return type
     * @return the entity
     */
    public <T> T getEntity(Class<T> returnType) {
        return HttpEntityHandler.handle(this, returnType, Boolean.TRUE);
    }


    /**
     * Gets the status from the previous Request
     *
     * @return the status code
     */
    public int getStatus() {
        return response.code();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStatusMessage() {
        return response.message();
    }

    /**
     * @return the input stream
     */
    public InputStream getInputStream() {
        return response.body().byteStream();
    }


    /**
     *
     * @return response as string
     */
    @Override
    public String responseAsString() {
        try {
            if(response.body() != null)
                return response.body().string();
        }catch (IOException e){
            LOG.warn("exception to get response: {}", e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Returns a Header value from the specified name key
     *
     * @param name the name of the header to query for
     * @return the header as a String or null if not found
     */
    public String header(String name) {
        return response.header(name);
    }

    /**
     * @return the a Map of Header Name to Header Value
     */
    public Map<String, String> headers() {
        Map<String, String> retHeaders = new HashMap<String, String>();
        Headers headers =  response.headers();

        for (String name : headers.names()) {
            retHeaders.put(name, headers.get(name));
        }
        return retHeaders;
    }

    @Override
    public <T> T readEntity(Class<T> typeToReadAs) {
        try {
            if( response.body() != null )
                return ObjectMapperSingleton.getContext(typeToReadAs).readerFor(typeToReadAs).readValue(response.body().string());
            return null;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new ClientResponseException(e.getMessage(), 0, e);
        }
    }

    @Override
    public void close() throws IOException {
        if (response != null && response.body() != null) {
            response.body().close();
        }
    }

    @Override
    public String getContentType() {
        return header(ClientConstants.HEADER_CONTENT_TYPE);
    }
}