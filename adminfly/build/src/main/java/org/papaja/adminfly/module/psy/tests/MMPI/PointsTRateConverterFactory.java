package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.MMPI.Q566.PointsTRateQ566Converter;
import org.papaja.adminfly.module.psy.tests.MMPI.Q71.PointsTRateQ71Converter;

import static java.lang.String.format;

public class PointsTRateConverterFactory {

    public static PointsTRateConverterInterface createConverter(Test test) {
        switch (test) {
            case MMPI_71:
                return new PointsTRateQ71Converter();
            case MMPI_566:
                return new PointsTRateQ566Converter(null);
            default:
                throw new IllegalArgumentException(format("Cannot create converter for '%s' test", test));
        }
    }

}
