package com.salesmore.yak.integration.shopee.model.common;

public abstract class Auth implements com.salesmore.yak.integration.core.common.Auth {

    private static final long serialVersionUID = 1L;

    private String partnerId;
    private String partnerKey;
    private String shopId;

    private transient Type type;

    protected Auth(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerKey() {
        return partnerKey;
    }

    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
