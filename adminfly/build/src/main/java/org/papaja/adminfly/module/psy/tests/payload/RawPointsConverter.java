package org.papaja.adminfly.module.psy.tests.payload;

import org.papaja.adminfly.module.psy.tests.MMPI.Scale;

import java.util.Map;

public class RawPointsConverter extends MapPayload<Scale, Integer> {
    public RawPointsConverter(Map<Scale, Integer> map) {
        super(map);
    }
}
