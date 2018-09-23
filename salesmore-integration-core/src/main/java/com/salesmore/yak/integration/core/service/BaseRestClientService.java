package com.salesmore.yak.integration.core.service;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.salesmore.yak.integration.core.api.exceptions.RestClientBaseException;
import com.salesmore.yak.integration.core.model.ErrorBaseResponse;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.core.transport.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.salesmore.yak.integration.core.constants.ClientConstants.HEADER_USER_AGENT;
import static com.salesmore.yak.integration.core.constants.ClientConstants.USER_AGENT;
import static com.salesmore.yak.integration.core.transport.HttpRequest.RequestBuilder;

public class BaseRestClientService {

    private Function<String, String> endpointFunc;

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected BaseRestClientService() {

    }


    protected BaseRestClientService(Function<String, String> endpointFunc) {
        this.endpointFunc = endpointFunc;
    }

    protected <R> Invocation<R> get(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.GET);
    }

    protected <R> Invocation<R> post(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.POST);
    }

    protected <R> Invocation<R> put(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.PUT);
    }

    protected <R> Invocation<R> patch(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.PATCH);
    }

    protected <R> Invocation<R> delete(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.DELETE);
    }

    protected <R> Invocation<R> head(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.HEAD);
    }

    protected <R> Invocation<R> request(HttpMethod method, Class<R> returnType, String path) {
        return builder(returnType, path, method);
    }

    protected String uri(String path, Object... params) {
        if (params.length == 0)
            return path;
        return String.format(path, params);
    }

    private <R> Invocation<R> builder(Class<R> returnType, String[] path, HttpMethod method) {
        return builder(returnType, Joiner.on("").join(path), method);
    }

    @SuppressWarnings("rawtypes")
    private <R> Invocation<R> builder(Class<R> returnType, String path, HttpMethod method) {
        BaseClientSession ses = BaseClientSession.getCurrent();
        if (ses == null) {
            throw new RestClientBaseException(
                    "Unable to retrieve current session. Please verify thread has a current session available.");
        }
        RequestBuilder<R> req = HttpRequest.builder(returnType).endpointTokenProvider(ses).config(ses.getConfig())
                .method(method).path(path);
        Map headers = ses.getHeaders();
        if (headers != null && headers.size() > 0){
            return new Invocation<R>(req, endpointFunc).headers(headers);
        }else{
            return new Invocation<R>(req, endpointFunc);
        }
    }

    protected static class Invocation<R> {
        RequestBuilder<R> req;

        protected Invocation(RequestBuilder<R> req, Function<String, String> endpointFunc) {
            this.req = req;
            req.endpointFunction(endpointFunc);
        }

        public HttpRequest<R> getRequest() {
            return req.build();
        }

        public Invocation<R> param(String name, Object value) {
            req.queryParam(name, value);
            return this;
        }

        public Invocation<R> updateParam(String name, Object value) {
            req.updateQueryParam(name, value);
            return this;
        }

        public Invocation<R> params(Map<String, ? extends Object> params) {
            if (params != null) {
                for (String name : params.keySet())
                    req.queryParam(name, params.get(name));
            }
            return this;
        }

        public Invocation<R> param(boolean condition, String name, Object value) {
            if (condition)
                req.queryParam(name, value);
            return this;
        }

        public Invocation<R> paramLists(Map<String, ? extends Iterable<? extends Object>> params) {
            if (params != null) {
                for (Map.Entry<String, ? extends Iterable<? extends Object>> pair : params.entrySet())
                    for (Object value : pair.getValue())
                        req.queryParam(pair.getKey(), value);
            }
            return this;
        }


        public Invocation<R> entity(ModelEntity entity) {
            req.entity(entity);
            return this;
        }

        public Invocation<R> entity(Object entity) {
            req.entity(entity);
            return this;
        }

        public Invocation<R> contentType(String contentType) {
            req.contentType(contentType);
            return this;
        }

        public Invocation<R> json(String json) {
            req.json(json);
            return this;
        }

        public Invocation<R> headers(Map<String, ? extends Object> headers) {
            if (headers != null)
                req.headers(headers);
            return this;
        }

        public Invocation<R> header(String name, Object value) {
            req.header(name, value);
            return this;
        }

        public R execute() {
            header(HEADER_USER_AGENT, USER_AGENT);
            HttpRequest<R> request = req.build();
            HttpResponse res = HttpExecutor.create().execute(request);

            return  res.getEntity(request.getReturnType());
        }

        public R executeWithErrorResponse() {
            R response = execute();
            if( response instanceof ErrorBaseResponse ){
                ErrorBaseResponse errorBase = (ErrorBaseResponse)response;
                if(!StringUtils.isEmpty(errorBase.getMsg()) && (null != errorBase.getError()))
                    throw HttpExceptionHandler.mapException(errorBase);
            }
            return response;
        }

        public HttpResponse executeWithResponse() {
            return HttpExecutor.create().execute(req.build());
        }

    }

    protected <T> List<T> toList(T[] arr) {
        if (arr == null)
            return Collections.emptyList();
        return Arrays.asList(arr);
    }
}
