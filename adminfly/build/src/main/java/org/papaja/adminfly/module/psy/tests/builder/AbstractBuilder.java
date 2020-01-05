package org.papaja.adminfly.module.psy.tests.builder;

import org.papaja.adminfly.module.psy.tests.Builder;

abstract public class AbstractBuilder<B extends AbstractBuilder, T> implements Builder<T> {
    protected B self() {
        return (B) this;
    }
}
