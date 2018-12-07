package com.salesmore.yak.integration.fyndiq.model.articles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.salesmore.yak.integration.fyndiq.model.common.ActionResponse;

import java.io.Serializable;
import java.util.List;

public class ArticleActionResponse implements ActionResponse {

    private static final long serialVersionUID = 1L;

    private String description;
    private List<Result> responses;

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Result> getResponses() {
        return responses;
    }

    public void setResponses(List<Result> responses) {
        this.responses = responses;
    }

    public static class Result implements Serializable{

        private static final long serialVersionUID = 1L;


        private String description;
        @JsonProperty("status_code")
        private String code;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).omitNullValues()
                    .add("description", description)
                    .add("code", code)
                    .toString();
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("description", description)
                .add("responses", responses)
                .toString();
    }
}
