package com.salesmore.yak.integration.shopee.model.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.core.service.ListResult;
import lombok.Data;

import java.util.List;

@Data
public class Category implements ModelEntity {

    private static final long serialVersionUID = 1L;

    /**
     * The Identify of each category
     */
    @JsonProperty("category_id")
    private Long id;

    /**
     * The Identify of the parent of the category
     */
    @JsonProperty("parent_id")
    private Long parentId;

    /**
     *  The name of each category
     */
    @JsonProperty("category_name")
    private String name;

    /**
     * This is to indicate whether the category has children.
     * Attributes can ONLY be fetched for the category_id WITHOUT children.
     */
    @JsonProperty("has_children")
    private boolean hasChildren;

    @Data
    public static class Categories extends ListResult<Category> {

        private static final long serialVersionUID = 1L;

        @JsonProperty("categories")
        private List<Category> categories;

        @Override
        protected List<Category> value() {
            return categories;
        }
    }
}
