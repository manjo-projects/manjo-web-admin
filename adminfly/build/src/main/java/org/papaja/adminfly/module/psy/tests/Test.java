package org.papaja.adminfly.module.psy.tests;

public enum Test {

    MMPI2("MMPI-2 - 566 Questions Test");

    private String name;

    Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
