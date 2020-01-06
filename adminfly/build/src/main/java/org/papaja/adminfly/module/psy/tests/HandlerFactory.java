package org.papaja.adminfly.module.psy.tests;

import org.papaja.adminfly.module.psy.tests.MMPI.MMPIHandler;

import static java.lang.String.format;

final public class HandlerFactory {

    public static Handler<?, Context> createHandler(Context context) {
        switch (context.getTest()) {
            case MMPI_566:
            case MMPI_71:
            case MMPI_377:
                return new MMPIHandler(context);
            default:
                throw new UnsupportedOperationException(format("Unsupported test '%s'", context.getTest()));
        }
    }

}
