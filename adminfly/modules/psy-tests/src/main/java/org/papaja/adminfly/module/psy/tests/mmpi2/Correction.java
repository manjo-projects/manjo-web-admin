package org.papaja.adminfly.module.psy.tests.mmpi2;

public class Correction {

    private int size;
    private float step;

    public Correction(int size, float step) {
        this.size = size;
        this.step = step;
    }

    public Correction(int size) {
        this(size, 1.0f);
    }

}
