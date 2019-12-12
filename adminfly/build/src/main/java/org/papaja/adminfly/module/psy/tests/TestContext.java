package org.papaja.adminfly.module.psy.tests;

import org.papaja.adminfly.module.psy.tests.MMPI.Gender;

abstract public class TestContext implements Context {

    protected UserDetails user;
    protected Test        test;

    public TestContext(Test test, UserDetails user) {
        this.test = test;
        this.user = user;
    }

    @Override
    public Gender getGender() {
        return getUsedDetails().getGender();
    }

    @Override
    public UserDetails getUsedDetails() {
        return user;
    }

    @Override
    public Test getTest() {
        return test;
    }

}
