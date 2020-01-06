package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.tuple.Pair;

public class Bounds extends Pair<Float, Float> {

    public Bounds(Float boundA, Float boundB) {
        super(boundA, boundB);
    }

    public float getBoundA() {
        return getA();
    }

    public float getBoundB() {
        return getB();
    }

}
