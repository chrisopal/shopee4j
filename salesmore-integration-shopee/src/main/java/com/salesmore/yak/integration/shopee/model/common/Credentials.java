package com.salesmore.yak.integration.shopee.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.identity.AuthStore;

import java.io.Serializable;

public class Credentials extends Auth implements AuthStore {

    private static final long serialVersionUID = 1L;

    private PasswordCredentials passwordCreds = new PasswordCredentials();

    public Credentials() {
        super(Type.CREDENTIALS);
    }

    public Credentials(String partnerId, String partnerKey) {
        this();
        setPartnerId(partnerId);
        setPartnerKey(partnerKey);
    }

    public Credentials(String partnerId, String partnerKey, String shopId) {
        this();
        setPartnerId(partnerId);
        setPartnerKey(partnerKey);
        setShopId(shopId);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    private static final class PasswordCredentials implements Serializable {

        private static final long serialVersionUID = 1L;

        @JsonProperty
        String username;
        @JsonProperty
        String password;

        public void setCredentials(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
