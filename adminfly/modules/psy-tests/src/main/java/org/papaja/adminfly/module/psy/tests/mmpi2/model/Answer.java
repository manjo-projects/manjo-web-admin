package org.papaja.adminfly.module.psy.tests.mmpi2.model;

public enum Answer {

    TRUE(1), FALSE(0);

    private int value;

    Answer(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
