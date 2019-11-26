package org.papaja.adminfly.module.psy.tests.mmpi2.calculator;

import org.papaja.adminfly.module.psy.tests.Calculator;
import org.papaja.adminfly.module.psy.tests.mmpi2.Points;
import org.papaja.adminfly.module.psy.tests.mmpi2.model.*;

import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.mmpi2.model.Scale.*;
import static org.papaja.adminfly.module.psy.tests.mmpi2.model.Sex.F;

public class RawPointsCalculator implements Calculator<Answer, Points> {

    private Sex sex;

    public RawPointsCalculator(Sex sex) {
        this.sex = sex;
    }

    @Override
    public Points calculate(Map<Integer, Answer> results) {
        Points points = new Points(sex);

        results.forEach((question, answer) -> {
            for (Scale scale : Data.INSTANCE.getScales(question, answer)) {

                // correction by gender
                if (scale.equals(SCALE_5_F) || scale.equals(SCALE_5_M)) {
                    scale = sex.equals(F) ? SCALE_5_F : SCALE_5_M;
                }

                points.increase(scale);
            }
        });

        Rates.valueOf(sex, SCALE_2).getTRate(points.points().get(SCALE_2));

//        System.out.println(Rates.INSTANCE.getTRate(sex, SCALE_2, points.points().get(SCALE_2)));

        return points;
    }
}
