package org.papaja.adminfly.module.psy.tests.mmpi2;

import java.util.EnumMap;
import java.util.Map;

public class AnswersPointsConverter implements AnswersPointsConverterInterface {

    private QuestionsInterface questions;

    public AnswersPointsConverter(QuestionsInterface questions) {
        this.questions = questions;
    }

    @Override
    public Map<Scale, Integer> convert(Map<Integer, Answer> results) {
        Map<Scale, Integer> points = new EnumMap<>(Scale.class);

        for (Scale scale : Scale.values()) {
            points.put(scale, 0);
        }

        results.forEach((question, answer) -> {
            for (Scale scale : questions.getScales(question, answer)) {
                points.put(scale, points.get(scale));
            }
        });

        return points;
    }
}
