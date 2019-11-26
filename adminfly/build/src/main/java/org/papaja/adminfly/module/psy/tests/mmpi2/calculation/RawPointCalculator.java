package org.papaja.adminfly.module.psy.tests.mmpi2.calculation;

import org.papaja.adminfly.module.psy.tests.Calculator;
import org.papaja.adminfly.module.psy.tests.mmpi2.Points;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.*;

import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.mmpi2.data.Questions.QUESTIONS;

public class RawPointCalculator implements Calculator<Map<Integer, Answer>, Points> {

    @Override
    public Points calculate(Map<Integer, Answer> results) {
        Points points = new Points();

        results.forEach((question, answer) -> {
            for (Scale scale : QUESTIONS.getScales(question, answer)) {
                points.increase(scale);
            }
        });

        return points;
    }
}
