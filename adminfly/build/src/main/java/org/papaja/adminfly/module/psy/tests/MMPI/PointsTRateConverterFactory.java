package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.Context;
import org.papaja.adminfly.module.psy.tests.MMPI.converter.PointsTRateConverter;
import org.papaja.adminfly.module.psy.tests.MMPI.converter.PointsTRateQ71Converter;

import static java.lang.String.format;

public class PointsTRateConverterFactory {

    public static PointsTRateConverterInterface createConverter(Context context) {
        switch (context.getTest()) {
            case MMPI_71:
                return new PointsTRateQ71Converter();
            case MMPI_566:
            case MMPI_377:
                return new PointsTRateConverter();
            default:
                throw new IllegalArgumentException(format("Cannot create converter for '%s' test", context.getTest()));
        }
    }

}
