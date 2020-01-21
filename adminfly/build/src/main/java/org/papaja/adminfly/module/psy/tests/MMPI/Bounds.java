package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.tuple.Pair;

public class Bounds extends Pair<Double, Double> {

    public Bounds(Double boundA, Double boundB) {
        super(boundA, boundB);
    }

    public double getBoundA() {
        return getA();
    }

    public double getBoundB() {
        return getB();
    }

}
