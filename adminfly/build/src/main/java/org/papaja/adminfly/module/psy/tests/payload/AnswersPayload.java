package org.papaja.adminfly.module.psy.tests.payload;

import org.papaja.adminfly.module.psy.tests.MMPI.Answer;

import java.util.Map;

public class AnswersPayload extends MapPayload<Integer, Answer> {
    public AnswersPayload(Map<Integer, Answer> map) {
        super(map);
    }
}
