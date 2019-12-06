package org.papaja.adminfly.module.psy.tests.mmpi2;

import org.papaja.function.Converter;

import java.util.Map;

public interface PointsTRateConverterInterface extends Converter<Map<Scale, Integer>, Map<Scale, Float>> {

    default Map<Scale, Float> getTRates(Map<Scale, Integer> points) {
        return convert(points);
    }

}
