package com.salesmore.yak.integration.shopee.model.common;

import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.core.transport.ListType;
import com.salesmore.yak.integration.shopee.model.ErrorResponse;

import java.util.Collections;
import java.util.List;

/**
 * A List response which wrappers a JSON Array
 *
 * @param <T> the generic type
 */
public abstract class ListResult<T> extends ErrorResponse implements ModelEntity, ListType {

    private static final long serialVersionUID = 1L;

    protected abstract List<T> value();

    public List<T> getList() {
        if (value() == null)
            return Collections.emptyList();
        return value();
    }


    public T first() {
        return value().isEmpty() ? null : value().get(0);
    }


    public boolean hasMore() { return false; }
}