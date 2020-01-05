package org.papaja.adminfly.module.psy.tests.MMPI.payload;

import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.payload.TuplePayload;
import org.papaja.tuple.Pair;

import java.util.Map;

public class RawPointsPayload extends TuplePayload<Pair<Map<Scale, Integer>, Gender>> {
    public RawPointsPayload(Pair<Map<Scale, Integer>, Gender> tuple) {
        super(tuple);
    }
}
