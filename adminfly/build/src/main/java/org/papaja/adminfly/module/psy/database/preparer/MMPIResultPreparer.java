package org.papaja.adminfly.module.psy.database.preparer;

import org.papaja.adminfly.module.psy.commons.function.Preparer;
import org.papaja.adminfly.module.psy.commons.function.Value;
import org.papaja.adminfly.module.psy.database.entity.results.MMPI.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;

import java.util.HashMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.Gender.F;

public class MMPIResultPreparer implements Preparer<AbstractMMPIResult, Map<Scale, Integer>> {

    private Gender gender;

    public MMPIResultPreparer(Gender gender) {
        this.gender = gender;
    }

    @Override
    public Value<Map<Scale, Integer>> prepare(AbstractMMPIResult result) {
        Map<Scale, Integer> formatted = new HashMap<>();
        Scale               scale5    = (gender.equals(F) ? Scale.SCALE_5_F : Scale.SCALE_5_M);

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
        formatted.put(scale5, result.getScale5());

        return new Value<>(formatted);
    }

}
