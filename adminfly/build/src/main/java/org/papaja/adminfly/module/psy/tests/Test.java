package org.papaja.adminfly.module.psy.tests;

public enum Test {

    MMPI2_SOBCHIK("MMPI2/566Q (Sobchik)"),
    MMPI2_ZAITSEV("MMPI2/71Q (Zaitsev/Koziulia)"),
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
