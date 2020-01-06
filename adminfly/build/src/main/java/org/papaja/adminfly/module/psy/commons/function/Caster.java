package org.papaja.adminfly.module.psy.commons.function;

final public class Caster {
    public static <T> T cast(Object source, Class<T> type) {
        return type.isInstance(source) ? type.cast(source) : null;
    }
}
