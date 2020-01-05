package org.papaja.adminfly.module.psy.tests;

public interface ContextAware<C extends Context> {
    C getContext();
}
