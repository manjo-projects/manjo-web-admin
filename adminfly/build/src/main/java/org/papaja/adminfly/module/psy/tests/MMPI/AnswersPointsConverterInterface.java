package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.ResultConverter;
import org.papaja.adminfly.module.psy.tests.MMPI.payload.AnswersPayload;

import java.util.Map;

public interface AnswersPointsConverterInterface extends ResultConverter<AnswersPayload, Map<Scale, Integer>> {

    default Map<Scale, Integer> getPoints(AnswersPayload payload) {
        return convert(payload);
    }

}
