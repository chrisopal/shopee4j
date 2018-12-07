package com.salesmore.yak.integration.fyndiq;

import com.salesmore.yak.integration.core.transport.HttpLoggingFilter;
import com.salesmore.yak.integration.fyndiq.api.FQClient;
import com.salesmore.yak.integration.fyndiq.service.FQClientFactory;

public abstract class AbstractTest {

    private static final String MERCHANT_ID = "3eb1d426-0b6e-4dcd-90d0-3c1547016ff1";
    private static final String TOKEN_ID = "6a43767e-0f13-47f7-831f-264bfb5589e3";

    private static final String SERVER_ENDPOINT = "https://merchants-api-sandbox.fyndiq.com/api/v1";

    static {
        System.setProperty("log4j.configurationFile","./log4j.xml");
        HttpLoggingFilter.toggleLogging(true);
    }

    protected FQClient fqClient;

    protected FQClient fqClient() {
         fqClient = FQClientFactory.newClient(MERCHANT_ID, TOKEN_ID, SERVER_ENDPOINT);
         return fqClient;
    }

}
