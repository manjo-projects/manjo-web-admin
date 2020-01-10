package org.papaja.adminfly.module.psy.tests.context;

public interface ContextAware<C extends Context> {
    C getContext();
}
