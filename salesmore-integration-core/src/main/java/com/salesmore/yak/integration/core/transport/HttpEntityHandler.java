package com.salesmore.yak.integration.core.transport;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.salesmore.yak.integration.core.transport.HttpExceptionHandler.mapException;

/**
 * Handles retrieving an Entity from an HttpResponse while validating resulting
 * status codes.
 *
 */
public class HttpEntityHandler {
    private static final Logger LOG = LoggerFactory.getLogger(HttpEntityHandler.class);

    public static <T> T handle(HttpResponse response, Class<T> returnType) {
        return handle(response, returnType, Boolean.FALSE);
    }

    public static <T> T handle(HttpResponse response, Class<T> returnType, boolean requiresVoidBodyHandling) {
        try {
            Handle<T> handle = Handle.create(response, returnType, requiresVoidBodyHandling);

            if (response.getStatus() >= 400) {

                if (handle404(handle).isComplete()) {
                    return handle.getReturnObject();
                }
                String responseAsString = response.responseAsString();
                throw mapException(StringUtils.isEmpty(responseAsString) ? response.getStatusMessage() : responseAsString, response.getStatus());
            }


            if (returnType == Void.class) {
                return null;
            }


            return response.readEntity(returnType);
        } finally {
            closeQuietly(response);
        }
    }

    private static <T> Handle<T> handle404(Handle<T> handle) {
        if (handle.getResponse().getStatus() == 404) {
            if (ListType.class.isAssignableFrom(handle.getReturnType()) ||
                    ObjectType.class.isAssignableFrom(handle.getReturnType())) {
                try {
                    return handle.complete(handle.getReturnType().newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }

        return handle.continueHandling();
    }

    /**
     * Closes an HttpResponse ignoring a possible IOException
     *
     * @param response the http response
     */
    public static void closeQuietly(HttpResponse response) {
        try {
            response.close();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Returns the status code and closes the response
     *
     * @param response the http response
     * @return the status code
     */
    public static int statusAndClose(HttpResponse response) {
        int status = response.getStatus();
        closeQuietly(response);
        return status;
    }
}
