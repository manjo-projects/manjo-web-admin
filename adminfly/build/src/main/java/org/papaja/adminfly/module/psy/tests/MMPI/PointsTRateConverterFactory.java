package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.MMPI.converter.PointsTRateConverter;
import org.papaja.adminfly.module.psy.tests.MMPI.converter.PointsTRateQ71Converter;

import static java.lang.String.format;

public class PointsTRateConverterFactory {

    public static PointsTRateConverterInterface createConverter(Test test, Gender gender) {
        switch (test) {
            case MMPI_71:
                return new PointsTRateQ71Converter();
            case MMPI_566:
            case MMPI_377:
                return new PointsTRateConverter(gender);
            default:
                throw new IllegalArgumentException(format("Cannot create converter for '%s' test", test));
        }
    }

}
