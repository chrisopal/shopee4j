package com.salesmore.yak.integration.fyndiq.model.articles;

import com.salesmore.yak.integration.fyndiq.common.Buildable;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.BulkActionBuilder;

/**
 * Bulk Action Generic Type
 *
 * @param <T>
 */
public interface BulkAction<T> extends ModelEntity, Buildable<BulkActionBuilder> {

    /**
     * Get Action Type
     *
     * @return action type
     */
    Action getAction();

    /**
     * Get Article Id of the action
     *
     * @return id
     */
    String getId();

    /**
     * Get Action Body
     *
     * @return generic object like article price, quantity, action create
     */
    T getBody();
}
