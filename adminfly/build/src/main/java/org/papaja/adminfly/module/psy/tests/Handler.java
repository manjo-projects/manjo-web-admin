package org.papaja.adminfly.module.psy.tests;

import org.papaja.adminfly.module.psy.commons.function.Value;

public interface Handler<R, C extends Context> extends ContextAware<C> {
    Value<R> handle(Value value);
}
