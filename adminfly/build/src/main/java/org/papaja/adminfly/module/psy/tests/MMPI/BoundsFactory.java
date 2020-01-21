package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.Test;

import static java.lang.String.format;

public class BoundsFactory {

    public static Bounds createBounds(Test test) {
        switch (test) {
            case MMPI_566:
                return new Bounds(30D, 60D);
            case MMPI_71:
                return new Bounds(25D, 90D);
            case MMPI_377:
                return new Bounds(40D, 77D);
            default:
                throw new IllegalArgumentException(format("Undefined sound for test %s", test));
        }
    }

}
