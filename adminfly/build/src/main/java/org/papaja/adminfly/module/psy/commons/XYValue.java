package org.papaja.adminfly.module.psy.commons;

import org.papaja.tuple.Pair;

public class XYValue<N extends Number> extends Pair<N, N> {

    public XYValue(N a, N b) {
        super(a, b);
    }

    public N getY() {
        return super.getB();
    }

    public N getX() {
        return super.getA();
    }

}
