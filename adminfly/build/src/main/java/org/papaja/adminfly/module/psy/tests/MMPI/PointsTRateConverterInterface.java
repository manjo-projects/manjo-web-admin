package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.ResultConverter;
import org.papaja.adminfly.module.psy.tests.payload.MapPayload;
import org.papaja.function.Converter;

import java.util.Map;

public interface PointsTRateConverterInterface extends ResultConverter<MapPayload<Map<Scale, Integer>>, Map<Scale, Float>> {

    default Map<Scale, Float> getTRates(MapPayload<Map<Scale, Integer>> payload) {
        return convert(payload);
    }

}
