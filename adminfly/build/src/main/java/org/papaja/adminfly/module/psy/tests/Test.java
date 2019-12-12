package org.papaja.adminfly.module.psy.tests;

public enum Test {

    MMPI_566("MMPI-566Q"),
    MMPI_71("MMPI-MiniMult-71Q"),
    MMPI_377("MMPI-377Q"),
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
