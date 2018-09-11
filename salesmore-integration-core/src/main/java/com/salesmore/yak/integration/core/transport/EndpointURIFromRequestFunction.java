package com.salesmore.yak.integration.core.transport;


import com.google.common.base.Function;

import static com.salesmore.yak.integration.core.constants.ClientConstants.URI_SEP;

/**
 * Builds a URI comprising of Endpoint and Path from a HttpRequest object
 *
 */
public class EndpointURIFromRequestFunction implements Function<HttpRequest<?>, String> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String apply(HttpRequest<?> request) {
        if (request.getEndpoint().endsWith(URI_SEP) || request.getPath().startsWith(URI_SEP))
            return escape(request.getEndpoint() + request.getPath());
        
        return escape(request.getEndpoint() + URI_SEP + request.getPath());
    }
    
    private String escape(String uri) {
        return uri.replaceAll(" ", "%20");
    }

}
