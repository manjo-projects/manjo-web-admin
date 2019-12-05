package org.papaja.adminfly.module.psy.tests;

public enum Test {

    MMPI_566("MMPI-2 566Q"),
    MMPI_71("MMPI-2 MiniMulti-71Q"),
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
