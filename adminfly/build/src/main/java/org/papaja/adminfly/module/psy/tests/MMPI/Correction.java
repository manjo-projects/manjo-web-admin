package org.papaja.adminfly.module.psy.tests.MMPI;

import static java.lang.Math.round;

public class Correction {

    private static final float DEFAULT_K = 30f;
    private static final float DEFAULT_T = 120f;

    private float factor;

    Correction(float factor, float ks, float ts) {
        this.factor = (ts / ks) / factor;
    }

    Correction(float factor, float ks) {
        this(factor, ks, DEFAULT_T);
    }

    Correction(float factor) {
        this(factor, DEFAULT_K, DEFAULT_T);
    }

    public int calculate(float rate) {
        return round(rate / factor);
    }

    public int subtract(float rate) {
        return round(rate * factor);
    }

}
