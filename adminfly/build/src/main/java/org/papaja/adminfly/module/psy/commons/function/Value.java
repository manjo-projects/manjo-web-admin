package org.papaja.adminfly.module.psy.commons.function;

import org.papaja.tuple.Unit;

import static java.lang.String.format;

public class Value<V> extends Unit<V> {

    private V value;

    public Value(V value) {
        super(value);
    }

    public boolean has() {
        return a != null;
    }

    public V get() {
        return a;
    }

    public <T> T get(Class<T> type) {
        return type.isInstance(a) ? type.cast(a) : null;
    }

    public void set(V value) {
        this.a = value;
    }

    public Class<?> type() {
        return has() ? get().getClass() : null;
    }

    @Override
    public V getA() {
        throw new UnsupportedOperationException(
                format("Method '%s#%s' is unavailable for this class", Unit.class.getName(), "getA"));
    }
}
