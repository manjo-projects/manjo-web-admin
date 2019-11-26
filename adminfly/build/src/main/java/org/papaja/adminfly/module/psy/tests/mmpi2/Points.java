package org.papaja.adminfly.module.psy.tests.mmpi2;

import org.papaja.adminfly.module.psy.tests.mmpi2.data.Scale;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Sex;

import java.util.EnumMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.mmpi2.data.Scale.*;
import static org.papaja.adminfly.module.psy.tests.mmpi2.data.Sex.F;

public class Points {

    private Map<Scale, Integer> points = new EnumMap<>(Scale.class);

    public Points() {
        for (Scale scale : Scale.values()) {
            points.put(scale, 0);
        }
    }

    public void increase(Scale scale) {
        points.put(scale, points.get(scale) + 1);
    }

    public void decrease(Scale scale) {
        points.put(scale, points.get(scale) - 1);
    }

    public int points(Scale scale) {
        return points.get(scale);
    }

    public Map<Scale, Integer> points() {
        return points;
    }

}
