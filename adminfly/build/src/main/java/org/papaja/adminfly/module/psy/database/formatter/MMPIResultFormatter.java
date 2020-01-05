package org.papaja.adminfly.module.psy.database.formatter;

import org.papaja.adminfly.module.psy.database.entity.results.MMPI.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.function.Formatter;

import java.util.HashMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.Gender.F;

public class MMPIResultFormatter implements Formatter<AbstractMMPIResult, Map<Scale, Integer>> {

    private Gender gender;

    public MMPIResultFormatter(Gender gender) {
        this.gender = gender;
    }

    @Override
    public Map<Scale, Integer> format(AbstractMMPIResult result) {
        Map<Scale, Integer> formatted = new HashMap<>();

        formatted.put(Scale.SCALE_L, result.getScaleL());
        formatted.put(Scale.SCALE_F, result.getScaleF());
        formatted.put(Scale.SCALE_K, result.getScaleK());
        formatted.put(Scale.SCALE_0, result.getScale0());
        formatted.put(Scale.SCALE_1, result.getScale1());
        formatted.put(Scale.SCALE_2, result.getScale2());
        formatted.put(Scale.SCALE_3, result.getScale3());
        formatted.put(Scale.SCALE_4, result.getScale4());
        formatted.put(Scale.SCALE_6, result.getScale6());
        formatted.put(Scale.SCALE_7, result.getScale7());
        formatted.put(Scale.SCALE_8, result.getScale8());
        formatted.put(Scale.SCALE_9, result.getScale9());

        formatted.put((gender.equals(F) ? Scale.SCALE_5_F : Scale.SCALE_5_M), result.getScale5());

        return formatted;
    }

}
