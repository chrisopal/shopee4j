package com.salesmore.yak.integration.fyndiq.model.articles;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * Supported Markets, Mapping to java.util.Locale.getCountry().
 *
 * So far it's only supported below markets, it can be extended or directly mapping to string.
 *
 */
public enum Status {
    UNRECOGNIZED(""), FOR_SALE("for sale"), PAUSED("paused"), DELETED("deleted") ;

    private String value;

    Status(String s){
        value = s;
    }

    @JsonValue
    public String getValue(){
        return value;
    }

    @JsonCreator
    public static Status value(String v)
    {
        for(Status s :Status.values()){
            if(s.getValue().equals(v))
                return s;
        }
        return UNRECOGNIZED;

    }
}

