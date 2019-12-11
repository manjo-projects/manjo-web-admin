package org.papaja.adminfly.module.psy.tests.MMPI;

public enum Gender {

    M("Male"), F("Female"), FM("Female-Male"), MF("Male-Female"), X("Unknown");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
