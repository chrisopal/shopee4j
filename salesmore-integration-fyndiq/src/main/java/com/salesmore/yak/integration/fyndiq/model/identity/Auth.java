package com.salesmore.yak.integration.fyndiq.model.identity;

public abstract class Auth implements com.salesmore.yak.integration.fyndiq.common.Auth {

    private static final long serialVersionUID = 1L;

    private String merchantId;
    private String token;

    private transient Type type;

    protected Auth(Type type) {
        this.type = type;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
