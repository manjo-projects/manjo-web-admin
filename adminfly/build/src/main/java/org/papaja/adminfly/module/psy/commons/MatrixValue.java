package org.papaja.adminfly.module.psy.commons;

import org.papaja.tuple.Quartet;

public class MatrixValue<V extends Number>
        extends Quartet<V, V, V, V> {

    public MatrixValue(V x0, V y0, V x1, V y2) {
        super(x0, y0, x1, y2);
    }

    public V getX0() {
        return super.getA();
    }

    public V getY0() {
        return super.getB();
    }

    public V getX1() {
        return super.getC();
    }

    public V getY1() {
        return super.getD();
    }

}
