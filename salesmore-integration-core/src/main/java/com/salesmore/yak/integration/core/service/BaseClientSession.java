package com.salesmore.yak.integration.core.service;

import com.google.common.annotations.VisibleForTesting;
import com.salesmore.yak.integration.core.api.AbstractRestClient;
import com.salesmore.yak.integration.core.api.EndpointTokenProvider;
import com.salesmore.yak.integration.core.transport.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * Abstract Client Session used for extension
 *
 * @param <R>
 * @param <T>
 */
public abstract class BaseClientSession<R, T extends AbstractRestClient<T>> implements EndpointTokenProvider {

    private static final Logger LOG = LoggerFactory.getLogger(BaseClientSession.class);

    protected static final ThreadLocal<BaseClientSession> sessions = new ThreadLocal<BaseClientSession>();

    Config config;
    Map<String, Object> headers = new HashMap<String, Object>();

    public static BaseClientSession getCurrent() {
        return sessions.get();
    }

    @SuppressWarnings("unchecked")
    @VisibleForTesting
    public R useConfig(Config config) {
        this.config = config;
        return (R) this;
    }

    /**
     * @return the original client configuration associated with this session
     */
    public Config getConfig() {
        return config;
    }

    /**
     * {@inheritDoc}
     */
    public T headers(Map<String, ? extends Object> headers) {
        this.headers.putAll(headers);
        return (T) this;
    }

    public T header(String name, Object value) {
        this.headers.put(name, value);
        return (T) this;
    }

    public Map<String, ? extends Object> getHeaders(){
        return this.headers;
    }
}
