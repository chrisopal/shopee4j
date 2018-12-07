package com.salesmore.yak.integration.fyndiq.model.identity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Credentials extends Auth implements AuthStore{

    private static final long serialVersionUID = 1L;

    private PasswordCredentials passwordCreds = new PasswordCredentials();

    public Credentials() {
        super(Type.CREDENTIALS);
    }

    public Credentials(String username, String password) {
        this();
        passwordCreds.setCredentials(username, password);
    }

    public Credentials(String username, String password, String merchantId) {
        this();
        passwordCreds.setCredentials(username, password);
        setMerchantId(merchantId);
    }

    public Credentials(String username, String password, String merchantId, String token) {
        this();
        passwordCreds.setCredentials(username, password);
        setMerchantId(merchantId);
        setToken(token);
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
