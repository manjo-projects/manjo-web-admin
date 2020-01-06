package org.papaja.adminfly.module.psy.tests;

public enum Test {

    MMPI_566("MMPI 566Q"),
    MMPI_71("MMPI Mini-Mult 71Q"),
    MMPI_377("MMPI 377Q"),
    SAMPLE("SAMPLE (DEMO)");

    private String name;

    Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
