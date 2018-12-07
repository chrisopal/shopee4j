package com.salesmore.yak.integration.fyndiq.service.internal;

import com.google.common.io.BaseEncoding;
import com.salesmore.yak.integration.core.service.BaseClientSession;
import com.salesmore.yak.integration.core.transport.Config;
import com.salesmore.yak.integration.core.transport.HttpRequest;
import com.salesmore.yak.integration.fyndiq.api.Apis;
import com.salesmore.yak.integration.fyndiq.api.FQClient;
import com.salesmore.yak.integration.fyndiq.api.domain.ArticlesService;
import com.salesmore.yak.integration.fyndiq.api.domain.OrdersService;
import com.salesmore.yak.integration.fyndiq.api.domain.SalesFunnelsService;
import com.salesmore.yak.integration.fyndiq.constants.ClientConstants;
import com.salesmore.yak.integration.fyndiq.model.identity.Credentials;

import java.nio.charset.StandardCharsets;

/**
 * Actual implementation for the Fyndiq Client Service Operations
 *
 */
public class FQClientSession extends BaseClientSession<FQClientSession, FQClient> implements FQClient {

    private Credentials credentials;
    private String endpoint;


    private FQClientSession(String endpoint, Credentials credentials, Config config){
        this.endpoint = endpoint;
        this.credentials = credentials;
        this.config = config;
        sessions.set(this);
    }

    public static FQClientSession createSession(String endpoint, Credentials credentials, Config config){
        FQClientSession session = new FQClientSession(endpoint, credentials, config);
        session.header(ClientConstants.HEADER_CONTENT_TYPE, ClientConstants.CONTENT_TYPE_JSON);
        return session;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }

    @Override
    public String getTokenId() {
        //{base64_encode(merchantID:token)}

        String token = BaseEncoding.base64().encode(String.format("%s:%s", credentials.getMerchantId(), credentials.getToken()).getBytes(StandardCharsets.UTF_8));
        return String.format("Basic %s", token);
    }

    @Override
    public <T> String getTokenId(HttpRequest<T> httpRequest) {
        return null;
    }

    @Override
    public String getAuthHeaderName() {
        return ClientConstants.HEADER_AUTHORIZATION;
    }

    @Override
    public ArticlesService articles() {
        return Apis.getArticlesService();
    }

    @Override
    public OrdersService orders() {
        return Apis.getOrdersService();
    }

    @Override
    public SalesFunnelsService salesFunnels() {
        return Apis.getSalesFunnelsService();
    }


}
