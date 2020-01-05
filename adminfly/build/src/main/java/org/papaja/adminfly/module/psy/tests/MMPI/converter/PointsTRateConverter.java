package org.papaja.adminfly.module.psy.tests.MMPI.converter;

import org.papaja.adminfly.module.psy.tests.MMPI.PointsTRateConverterInterface;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.MMPI.formula.Formula;
import org.papaja.adminfly.module.psy.tests.MMPI.formula.FormulaData;
import org.papaja.adminfly.module.psy.tests.payload.MapPayload;

import java.util.HashMap;
import java.util.Map;

public class PointsTRateConverter implements PointsTRateConverterInterface {

    private static final Formula     FORMULA = new Formula();
    private static final FormulaData DATA    = FormulaData.MAP;

    @Override
    public Map<Scale, Float> convert(MapPayload<Map<Scale, Integer>> payload) {
        Map<Scale, Float>             output = new HashMap<>();
        Map<Scale, Integer>           input  = payload.getValue();
        Map<Scale, FormulaData.Value> values = DATA.getValues(payload.getGender());

        input.forEach((scale, points)
                -> output.put(scale, FORMULA.apply(points, values.get(scale).getIndex(), values.get(scale).getIndex())));

        return output;
    }
}
