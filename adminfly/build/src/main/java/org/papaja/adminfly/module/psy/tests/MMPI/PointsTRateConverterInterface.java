package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.function.Converter;

import java.util.Map;

public interface PointsTRateConverterInterface extends Converter<Map<Scale, Integer>, Map<Scale, Float>> {

    default Map<Scale, Float> getTRates(Map<Scale, Integer> points) {
        return convert(points);
    }

}
