package org.papaja.adminfly.module.psy.tests.MMPI;

import java.util.EnumMap;
import java.util.Map;

public class AnswersPointsConverter implements AnswersPointsConverterInterface {

    private Answers answers;

    public AnswersPointsConverter(Answers answers) {
        this.answers = answers;
    }

    @Override
    public Map<Scale, Integer> convert(Map<Integer, Answer> results) {
        Map<Scale, Integer> points = new EnumMap<>(Scale.class);

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
