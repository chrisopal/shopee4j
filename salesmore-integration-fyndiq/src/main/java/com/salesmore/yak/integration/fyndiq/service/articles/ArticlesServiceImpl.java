package com.salesmore.yak.integration.fyndiq.service.articles;

import com.salesmore.yak.integration.core.service.BaseRestClientService;
import com.salesmore.yak.integration.fyndiq.api.domain.ArticlesService;
import com.salesmore.yak.integration.fyndiq.model.articles.*;
import com.salesmore.yak.integration.fyndiq.model.common.EntityResponse;
import com.salesmore.yak.integration.fyndiq.service.articles.domain.ConcreteArticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.salesmore.yak.integration.fyndiq.constants.ClientConstants.*;

public class ArticlesServiceImpl extends BaseRestClientService implements ArticlesService {

    private static final Logger LOG = LoggerFactory.getLogger(ArticlesServiceImpl.class);

    @Override
    public List<? extends Article> list() {

        return Arrays.asList(get(ConcreteArticle[].class, uri(ARTICLES_RELATIVE_PATH)).execute());
    }

    @Override
    public List<? extends Article> list(Map<String, String> filteringParams) {
        return Arrays.asList(get(ConcreteArticle[].class, uri(ARTICLES_RELATIVE_PATH)).params(filteringParams).execute());
    }

    @Override
    public Article get(String articleId) {
        checkNotNull(articleId);
        return get(ConcreteArticle.class, uri("/articles/%s", articleId)).execute();
    }

    @Override
    public EntityResponse create(ArticleCreate articleCreate) {
        checkNotNull(articleCreate);
        checkNotNull(validateMainTag(articleCreate.getTags()));
        return post(EntityResponse.class, uri(ARTICLES_RELATIVE_PATH)).entity(articleCreate).execute();
    }

    @Override
    public void update(String articleId, ArticleCreate articleUpdate) {
        checkNotNull(articleId);
        checkNotNull(validateMainTag(articleUpdate.getTags()));
        put(Void.class, uri(ARTICLES_PATH, articleId)).entity(articleUpdate).execute();
    }

    @Override
    public void updatePrice(String articleId, ArticlePrice articlePrice) {
        checkNotNull(articleId);
        checkNotNull(articlePrice);
        put(Void.class, uri(ARTICLES_PRICE_PATH, articleId)).entity(articlePrice).execute();
    }

    @Override
    public void updateQuantity(String articleId, Quantity quantity) {
        checkNotNull(articleId);
        checkNotNull(quantity, "Quantity Must Not be Null");
        put(Void.class, uri(ARTICLES_QUANTITY_PATH, articleId)).entity(quantity).execute();
    }

    @Override
    public ArticleActionResponse bulkAction(List<BulkAction> bulkActions) {
        checkNotNull(bulkActions);
        return post(ArticleActionResponse.class, uri(ARTICLES_BULK_ACTION_PATH)).entity(bulkActions).execute();
    }

    @Override
    public void delete(String articleId) {
        checkNotNull(articleId);
        delete(Void.class, uri(ARTICLES_PATH, articleId)).execute();
    }

    private Tag validateMainTag(List<String> tags) {
        for (String t : tags) {
            Tag mainTag = Tag.from(t);
            if (mainTag != null)
                return mainTag;
        }
        return null;
    }
}
