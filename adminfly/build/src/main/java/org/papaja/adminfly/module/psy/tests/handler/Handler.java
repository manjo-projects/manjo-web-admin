package org.papaja.adminfly.module.psy.tests.handler;

import org.papaja.adminfly.module.psy.commons.function.Value;
import org.papaja.adminfly.module.psy.tests.context.Context;
import org.papaja.adminfly.module.psy.tests.context.ContextAware;

public interface Handler<R, C extends Context> extends ContextAware<C> {
    Value<R> handle(Value value);
}
