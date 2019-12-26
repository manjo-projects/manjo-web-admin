package org.papaja.adminfly.module.psy.tests;

public enum Gender {

    M("Male"), F("Female"), FM("Female-Male"), MF("Male-Female");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
