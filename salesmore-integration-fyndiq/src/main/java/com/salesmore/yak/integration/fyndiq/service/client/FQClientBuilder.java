package com.salesmore.yak.integration.fyndiq.service.client;

import com.salesmore.yak.integration.core.api.exceptions.AuthenticationException;
import com.salesmore.yak.integration.core.service.BaseRestClientBuilder;
import com.salesmore.yak.integration.fyndiq.api.FQClient;
import com.salesmore.yak.integration.fyndiq.api.client.IFQClientBuilder;
import com.salesmore.yak.integration.fyndiq.model.identity.Credentials;
import com.salesmore.yak.integration.fyndiq.service.internal.FQClientSession;

/**
 * Builder to create a client
 *
 */
public class FQClientBuilder extends BaseRestClientBuilder<FQClient, IFQClientBuilder> implements IFQClientBuilder {

    private String merchantId;
    private String token;

    @Override
    public IFQClientBuilder token(String tokenId) {
        this.token = tokenId;
        return this;
    }

    @Override
    public IFQClientBuilder merchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    @Override
    public FQClient authenticate() throws AuthenticationException {
        return FQClientSession.createSession(endpoint, new Credentials(user, password, merchantId, token), config);
    }
}
