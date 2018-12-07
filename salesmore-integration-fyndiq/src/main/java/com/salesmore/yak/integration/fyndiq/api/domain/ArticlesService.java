package com.salesmore.yak.integration.fyndiq.api.domain;


import com.salesmore.yak.integration.core.common.RestService;
import com.salesmore.yak.integration.fyndiq.model.articles.*;
import com.salesmore.yak.integration.fyndiq.model.common.EntityResponse;

import java.util.List;
import java.util.Map;

/**
 * Articles Service Operation APIs
 */
public interface ArticlesService extends RestService {

    /**
     * Get all articles without any filter
     *
     * @return list of articles
     */
    List<? extends Article> list();


    /**
     * Get all articles with query params limit and page or other future query extension
     *
     * @param filteringParams filtering params
     * @return
     */
    List<? extends Article> list(Map<String, String> filteringParams);

    /**
     * Retrieve Article with Given Id
     *
     * @param articleId unique id of the article
     * @return queried article
     */
    Article get(String articleId);

    /**
     * Create an article
     *
     * @param articleCreate request body
     * @return response body
     */
    EntityResponse create(ArticleCreate articleCreate);

    /**
     * Update Article Properties
     *
     * @param articleId     article id to update
     * @param articleUpdate article object
     */
    void update(String articleId, ArticleCreate articleUpdate);

    /**
     * Update Article Price
     *
     * @param articleId    article id to update
     * @param articlePrice price info to update
     */
    void updatePrice(String articleId, ArticlePrice articlePrice);

    /**
     * Update Article Quantity
     *
     * @param articleId article id to update
     * @param quantity  quantity
     */
    void updateQuantity(String articleId, Quantity quantity);


    ArticleActionResponse bulkAction(List<BulkAction> bulkActions);

    /**
     * Delete Article with given article Id
     *
     * @param articleId to delete
     */
    void delete(String articleId);
}
