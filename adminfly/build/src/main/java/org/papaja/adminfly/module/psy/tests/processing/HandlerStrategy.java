package org.papaja.adminfly.module.psy.tests.processing;

import org.papaja.adminfly.module.psy.tests.Context;
import org.papaja.adminfly.module.psy.tests.ContextAware;

public interface HandlerStrategy<R, C extends Context> extends ContextAware {
    R handle();
}
