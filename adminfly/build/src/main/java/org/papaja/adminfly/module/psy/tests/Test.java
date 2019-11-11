package org.papaja.adminfly.module.psy.tests;

public enum Test {

    MMPI2("MMPI2/566Q"),
    SCHMIESCHEK("Schmieschek"),
    YAKHIN("Yakhin-Mendelevich");

    private String name;

    Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
