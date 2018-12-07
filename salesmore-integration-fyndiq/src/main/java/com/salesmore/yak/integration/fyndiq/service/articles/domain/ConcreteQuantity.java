package com.salesmore.yak.integration.fyndiq.service.articles.domain;

import com.salesmore.yak.integration.fyndiq.model.articles.Quantity;
import com.salesmore.yak.integration.fyndiq.model.articles.builder.QuantityBuilder;

/**
 * Quantity Implementation
 */
public class ConcreteQuantity implements Quantity {

    public static final long serialVersionUID = 1L;

    int quantity;

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public QuantityBuilder toBuilder() {
        return new ConcreteQuantityBuilder(this);
    }

    public static QuantityBuilder builder() {
        return new ConcreteQuantityBuilder();
    }

    public static class ConcreteQuantityBuilder implements QuantityBuilder {


        ConcreteQuantity c;

        public ConcreteQuantityBuilder() {
            this(new ConcreteQuantity());
        }

        public ConcreteQuantityBuilder(ConcreteQuantity cq){
            c = cq;
        }

        public static final long serialVersionUID = 1L;

        @Override
        public QuantityBuilder quantity(int quantity) {
            c.quantity = quantity;
            return this;
        }

        @Override
        public Quantity build() {
            return c;
        }

        @Override
        public QuantityBuilder from(Quantity in) {
            c = (ConcreteQuantity)in;
            return this;
        }
    }
}
