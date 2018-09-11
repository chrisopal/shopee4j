package com.salesmore.yak.integration.shopee.service.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.salesmore.yak.integration.core.constants.ClientConstants;
import com.salesmore.yak.integration.core.service.BaseClientSession;
import com.salesmore.yak.integration.core.transport.Config;
import com.salesmore.yak.integration.core.transport.HttpRequest;
import com.salesmore.yak.integration.core.transport.ObjectMapperSingleton;
import com.salesmore.yak.integration.shopee.api.Apis;
import com.salesmore.yak.integration.shopee.api.ShopeeClient;
import com.salesmore.yak.integration.shopee.api.domain.ShopService;
import com.salesmore.yak.integration.shopee.model.common.Credentials;
import com.salesmore.yak.integration.shopee.utils.HashingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShopeeClientSession extends BaseClientSession<ShopeeClientSession, ShopeeClient> implements ShopeeClient {

    private static final Logger log = LoggerFactory.getLogger(ShopeeClientSession.class);

    private Credentials credentials;
    private String endpoint;



    private ShopeeClientSession(String endpoint, Credentials credentials, Config config){
        this.endpoint = endpoint;
        this.credentials = credentials;
        this.config = config;
        sessions.set(this);
    }

    public static ShopeeClientSession createSession(String endpoint, Credentials credentials, Config config){
        ShopeeClientSession session = new ShopeeClientSession(endpoint, credentials, config);
        session.header(ClientConstants.HEADER_CONTENT_TYPE, ClientConstants.CONTENT_TYPE_JSON);
        return session;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }

    @Override
    public String getTokenId() {
        return null;
    }

    //https://open.shopee.com/documents?module=63&type=2&id=53
    @Override
    public <T> String getTokenId(HttpRequest<T> httpRequest) {

        String url = httpRequest.getEndpoint() + httpRequest.getPath();
        String requestAsJson = "";
        if(httpRequest.getEntity() != null){
            try {
                requestAsJson = ObjectMapperSingleton.getContext(ShopeeClientSession.class).writeValueAsString(httpRequest.getEntity());
            }catch (JsonProcessingException e) {
                log.error("Exception while convert request to JSON: {}", e.toString());
            }
        }
        return HashingUtils.hmacSHA256Digest(String.format("%s|%s", url, requestAsJson), credentials.getPartnerKey());
    }

    @Override
    public String getAuthHeaderName() {
        return ClientConstants.HEADER_AUTHORIZATION;
    }

    @Override
    public ShopService shops() {
        return Apis.getShopService();
    }
}
