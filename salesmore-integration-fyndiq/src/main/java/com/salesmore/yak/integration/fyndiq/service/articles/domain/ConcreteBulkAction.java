package com.salesmore.yak.integration.fyndiq.service.articles.domain;

import com.google.common.base.MoreObjects;
import com.salesmore.yak.integration.fyndiq.model.articles.Action;
import com.salesmore.yak.integration.fyndiq.model.articles.BulkAction;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.BulkActionBuilder;

public class ConcreteBulkAction<T> implements BulkAction<T> {

    Action action;
    String id;
    T body;

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public T getBody() {
        return body;
    }

    @Override
    public BulkActionBuilder<T> toBuilder() {
        return new ConcreteBulkActionBuilder<T>(this);
    }

    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("action", action)
                .add("id", id)
                .add("body", body)
                .toString();
    }

    public static <R> BulkActionBuilder<R> builder() { return new ConcreteBulkActionBuilder<R>(); }

    public static class ConcreteBulkActionBuilder<T> implements BulkActionBuilder<T> {

        ConcreteBulkAction<T> c;

        public ConcreteBulkActionBuilder() {
            this(new ConcreteBulkAction<T>());
        }

        public ConcreteBulkActionBuilder(ConcreteBulkAction<T> in){
            c = in;
        }

        @Override
        public BulkActionBuilder<T> action(Action action) {
            c.action = action;
            return this;
        }

        @Override
        public BulkActionBuilder<T> id(String id) {
            c.id = id;
            return this;
        }

        @Override
        public BulkActionBuilder<T> body(T body) {
            c.body = body;
            return this;
        }

        @Override
        public BulkAction<T> build() {
            return c;
        }

        @Override
        public BulkActionBuilder<T> from(BulkAction<T> in) {
            c = (ConcreteBulkAction<T>)in;
            return null;
        }
    }
}
