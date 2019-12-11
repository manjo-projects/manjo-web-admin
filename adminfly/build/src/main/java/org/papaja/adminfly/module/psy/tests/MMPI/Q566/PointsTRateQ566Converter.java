package org.papaja.adminfly.module.psy.tests.MMPI.Q566;

import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.MMPI.Gender;
import org.papaja.adminfly.module.psy.tests.MMPI.PointsTRateConverterInterface;

import java.util.HashMap;
import java.util.Map;

public class PointsTRateQ566Converter implements PointsTRateConverterInterface {

    private static final Formula  FORMULA   = new Formula();
    private static final ValueMap VALUE_MAP = ValueMap.MAP;

    private Gender sex;

    public PointsTRateQ566Converter(Gender sex) {
        this.sex = sex;
    }

    @Override
    public Map<Scale, Float> convert(Map<Scale, Integer> input) {
        Map<Scale, Float>          output = new HashMap<>();
        Map<Scale, ValueMap.Value> values = VALUE_MAP.getValues(sex);

        input.forEach((scale, points)
                -> output.put(scale, FORMULA.apply(points, values.get(scale).getIndex(), values.get(scale).getIndex())));

        return output;
    }

}
