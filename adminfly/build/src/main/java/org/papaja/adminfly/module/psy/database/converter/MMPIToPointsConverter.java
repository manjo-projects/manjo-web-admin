package org.papaja.adminfly.module.psy.database.converter;

import org.papaja.adminfly.module.psy.database.entity.results.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.function.Converter;

import java.util.HashMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.Gender.F;

public class MMPIToPointsConverter<Result extends AbstractMMPIResult>
        implements Converter<Result, Map<Scale, Integer>> {

    @Override
    public Map<Scale, Integer> convert(Result result) {
        Map<Scale, Integer> points = new HashMap<>();
        Gender              gender = result.getPatient().getSex();

        points.put(Scale.SCALE_L, result.getScaleL());
        points.put(Scale.SCALE_F, result.getScaleF());
        points.put(Scale.SCALE_K, result.getScaleK());
        points.put(Scale.SCALE_0, result.getScale0());
        points.put(Scale.SCALE_1, result.getScale1());
        points.put(Scale.SCALE_2, result.getScale2());
        points.put(Scale.SCALE_3, result.getScale3());
        points.put(Scale.SCALE_4, result.getScale4());
        points.put(Scale.SCALE_6, result.getScale6());
        points.put(Scale.SCALE_7, result.getScale7());
        points.put(Scale.SCALE_8, result.getScale8());
        points.put(Scale.SCALE_9, result.getScale9());

        points.put((gender.equals(F) ? Scale.SCALE_5_F : Scale.SCALE_5_M), result.getScale5());

        return points;
    }

}
