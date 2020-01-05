package org.papaja.adminfly.module.psy.tests.builder.context;

import org.papaja.adminfly.module.psy.tests.Context;
import org.papaja.adminfly.module.psy.tests.context.TestContext;

public class TestContextBuilder extends AbstractTestContextBuilder<TestContextBuilder, Context> {
    public TestContextBuilder() {
        this.context = new TestContext();
    }
}
