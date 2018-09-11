package com.salesmore.yak.integration.core.transport;



/**
 * A Service which is responsible of execution an HttpRequest
 *
 */
public interface HttpExecutorService {

    /**
     * Executes the given request and returns the {@code HttpResponse} response from the server
     *
     * @param <R> the underlying return entity type
     * @param request the request to execute
     * @return HttpResponse from the server
     */
    <R> HttpResponse execute(HttpRequest<R> request);

    /**
     * @return the executors display friendly name.  useful for logging or tests
     */
    String getExecutorDisplayName();
}
