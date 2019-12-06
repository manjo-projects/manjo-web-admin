package org.papaja.adminfly.module.psy.tests.mmpi2;

import org.papaja.function.Converter;

import java.util.Map;

public interface AnswersPointsConverterInterface extends Converter<Map<Integer, Answer>, Map<Scale, Integer>> {

    default Map<Scale, Integer> getPoints(Map<Integer, Answer> answers) {
        return convert(answers);
    }

}
