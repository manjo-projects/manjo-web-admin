package org.papaja.adminfly.module.psy.tests.MMPI.formula;

import org.papaja.function.TriFunction;

public class Formula implements TriFunction<Float, Integer, Float, Float> {

    @Override
    public Float apply(Integer x, Float index, Float sigma) {
        // Т = 50 + 10 (Х – М) / δ
        // X = RAW-POINT
        // index = М
        // sigma = δ
        return 50 + ((10 * (x - index)) / sigma);
    }

}
