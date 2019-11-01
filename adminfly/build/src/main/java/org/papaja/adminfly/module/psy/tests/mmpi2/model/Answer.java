package org.papaja.adminfly.module.psy.tests.mmpi2.model;

public enum Answer {

    F(0), T(1);

    private int value;

    Answer(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Answer valueOf(int value) {
        Answer answer = F;

        if (value == 1) {
            answer = T;
        }

        return answer;
    }

}
