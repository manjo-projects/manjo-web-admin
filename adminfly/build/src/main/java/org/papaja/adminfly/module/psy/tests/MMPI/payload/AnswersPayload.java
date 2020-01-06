package org.papaja.adminfly.module.psy.tests.MMPI.payload;

import org.papaja.adminfly.module.psy.tests.MMPI.Answer;
import org.papaja.adminfly.module.psy.tests.MMPI.Answers;
import org.papaja.adminfly.module.psy.tests.payload.TuplePayload;
import org.papaja.tuple.Pair;

import java.util.Map;

public class AnswersPayload extends TuplePayload<Pair<Map<Integer, Answer>, Answers>> {
    public AnswersPayload(Pair<Map<Integer, Answer>, Answers> tuple) {
        super(tuple);
    }
}
