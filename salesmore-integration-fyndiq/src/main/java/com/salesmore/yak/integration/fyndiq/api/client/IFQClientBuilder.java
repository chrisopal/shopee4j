package com.salesmore.yak.integration.fyndiq.api.client;

import com.salesmore.yak.integration.core.api.IRestClientBuilder;
import com.salesmore.yak.integration.fyndiq.api.FQClient;

public interface IFQClientBuilder extends IRestClientBuilder<FQClient, IFQClientBuilder> {

    IFQClientBuilder token(String tokenId);


    IFQClientBuilder merchantId(String merchantId);

}
