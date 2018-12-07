package com.salesmore.yak.integration.fyndiq.model.articles.builder;

import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.fyndiq.model.articles.Action;
import com.salesmore.yak.integration.fyndiq.model.articles.BulkAction;

/**
 * Builder for BulkAction
 *
 * @param <T>
 */
public interface BulkActionBuilder<T> extends Buildable.Builder<BulkActionBuilder<T>, BulkAction<T>> {


    /**
     * Set Action Type
     *
     * @param action operation type
     * @return Builder
     */
    BulkActionBuilder<T> action(Action action);

    /**
     * Set Article Id
     *
     * @param id set article id
     * @return Builder
     */
    BulkActionBuilder<T> id(String id);

    /**
     * Set
     *
     * @param body action body to set
     * @return Builder
     */
    BulkActionBuilder<T> body(T body);
}
