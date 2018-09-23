package com.salesmore.yak.integration.core.service;


import com.salesmore.yak.integration.core.model.ModelEntity;
import com.salesmore.yak.integration.core.transport.ObjectType;

/**
 * A Object response which wrappers a JSON object
 *
 * @param <T> the generic type
 */
public abstract class ObjectResult<T> implements ModelEntity, ObjectType {

    private static final long serialVersionUID = 1L;

    protected abstract T value();

    public T get(Class<T> clazz) {
        if (value() == null) {
            try {
                return clazz.newInstance();
            }catch (IllegalAccessException | InstantiationException e){
                return null;
            }
        }
        return value();
    }
}
