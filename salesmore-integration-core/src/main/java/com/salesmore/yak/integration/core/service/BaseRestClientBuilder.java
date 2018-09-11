package com.salesmore.yak.integration.core.service;

import com.salesmore.yak.integration.core.api.IRestClientBuilder;
import com.salesmore.yak.integration.core.transport.Config;

public abstract class BaseRestClientBuilder<R, T extends IRestClientBuilder<R, T>> implements IRestClientBuilder<R, T> {

    protected Config config;
    protected String endpoint;
    protected String authEndpoint;
    protected String user;
    protected String password;


    @SuppressWarnings("unchecked")
    @Override
    public T withConfig(Config config) {
        this.config = config;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T credentials(String userId, String password) {
        this.user = userId;
        this.password = password;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T endpoint(String endpoint) {
        this.endpoint = endpoint;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T authEndpoint(String endpoint) {
        this.authEndpoint = endpoint;
        return (T) this;
    }
}
