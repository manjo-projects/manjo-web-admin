package org.papaja.adminfly.module.psy.tests.builder.context;

import org.papaja.adminfly.module.psy.tests.*;
import org.papaja.adminfly.module.psy.tests.builder.AbstractBuilder;
import org.papaja.adminfly.module.psy.tests.context.Context;

abstract public class AbstractTestContextBuilder<B extends AbstractTestContextBuilder<B, C>, C extends Context>
        extends AbstractBuilder<B, C> {

    protected C context;

    public B with(Test test) {
        context.setTest(test);

        return self();
    }

    public B with(Gender gender) {
        context.setGender(gender);

        return self();
    }

    @Override
    public C build() {
        return context;
    }

}
