package org.papaja.adminfly.module.psy.tests.MMPI.converter;

import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.MMPI.formula.Formula;
import org.papaja.adminfly.module.psy.tests.MMPI.formula.FormulaData;
import org.papaja.function.Converter;

import java.util.HashMap;
import java.util.Map;

// gender
// input-map
public class PointsTRateConverter implements Converter<Map<Scale, Integer>, Map<Scale, Float>> {

    private static final Formula     FORMULA = new Formula();
    private static final FormulaData DATA    = FormulaData.MAP;

    private Gender gender;

    public PointsTRateConverter(Gender gender) {
        this.gender = gender;
    }

    @Override
    public Map<Scale, Float> convert(Map<Scale, Integer> input) {
        Map<Scale, Float>             output = new HashMap<>();
        Map<Scale, FormulaData.Value> values = DATA.getValues(gender);

        input.forEach((scale, points)
                -> output.put(scale, FORMULA.apply(points, values.get(scale).getIndex(), values.get(scale).getIndex())));

        return output;
    }
}
