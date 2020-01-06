package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.function.Converter;

import java.util.EnumMap;
import java.util.Map;

public class AnswersConverter implements Converter<Map<Integer, Answer>, Map<Scale, Integer>> {

    private Answers answers;

    public AnswersConverter(Answers answers) {
        this.answers = answers;
    }

    @Override
    public Map<Scale, Integer> convert(Map<Integer, Answer> input) {
        Map<Scale, Integer> points = new EnumMap<>(Scale.class);

        for (Scale scale : Scale.values()) {
            points.put(scale, 0);
        }

        input.forEach((question, answer) -> {
            for (Scale scale : answers.getScales(question, answer)) {
                points.put(scale, points.get(scale) + 1);
            }
        });

        return points;
    }
}
