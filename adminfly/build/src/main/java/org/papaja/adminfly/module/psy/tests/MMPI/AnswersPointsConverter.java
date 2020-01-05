package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.MMPI.payload.AnswersPayload;
import org.papaja.tuple.Pair;

import java.util.EnumMap;
import java.util.Map;

public class AnswersPointsConverter implements AnswersPointsConverterInterface {

    @Override
    public Map<Scale, Integer> convert(AnswersPayload payload) {
        Pair<Map<Integer, Answer>, Answers> tuple   = payload.getValue();
        Map<Scale, Integer>                 points  = new EnumMap<>(Scale.class);
        Map<Integer, Answer>                results  = tuple.getA();
        Answers                             answers = tuple.getB();

        for (Scale scale : Scale.values()) {
            points.put(scale, 0);
        }

        results.forEach((question, answer) -> {
            for (Scale scale : answers.getScales(question, answer)) {
                points.put(scale, points.get(scale) + 1);
            }
        });

        return points;
    }
}
