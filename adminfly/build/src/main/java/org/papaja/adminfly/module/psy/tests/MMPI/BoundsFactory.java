package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.Test;

import static java.lang.String.format;

public class BoundsFactory {

    public static Bounds createBounds(Test test) {
        switch (test) {
            case MMPI_566:
                return new Bounds(30F, 60F);
            case MMPI_71:
                return new Bounds(25F, 90F);
            case MMPI_377:
                return new Bounds(40F, 77F);
            default:
                throw new IllegalArgumentException(format("Undefined sound for test %s", test));
        }
    }

}
