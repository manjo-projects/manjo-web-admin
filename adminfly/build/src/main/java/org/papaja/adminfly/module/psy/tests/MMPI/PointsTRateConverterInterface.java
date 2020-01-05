package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.ResultConverter;
import org.papaja.adminfly.module.psy.tests.MMPI.payload.RawPointsPayload;

import java.util.Map;

public interface PointsTRateConverterInterface extends ResultConverter<RawPointsPayload, Map<Scale, Float>> {

    default Map<Scale, Float> getTRates(RawPointsPayload payload) {
        return convert(payload);
    }

}
