package org.papaja.adminfly.module.psy.tests.context;

import org.papaja.adminfly.module.psy.tests.*;

public class TestContext implements Context {

    private Gender gender;
    private Test   test;

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public Test getTest() {
        return test;
    }

    @Override
    public void setTest(Test test) {
        this.test = test;
    }

}
