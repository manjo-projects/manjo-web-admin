package org.papaja.adminfly.module.psy.tests.mmpi2;

import org.papaja.adminfly.module.psy.tests.mmpi2.model.Scale;
import org.papaja.adminfly.module.psy.tests.mmpi2.model.Sex;

import java.util.EnumMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.mmpi2.model.Scale.*;
import static org.papaja.adminfly.module.psy.tests.mmpi2.model.Sex.F;

public class Points {

    private Map<Scale, Integer> points = new EnumMap<>(Scale.class);

    public Points(Sex sex) {
        for (Scale scale : Scale.values()) {
            scale = (scale.equals(SCALE_5_F) || scale.equals(SCALE_5_M))
                    ? (sex.equals(F) ? SCALE_5_F : SCALE_5_M) : scale;
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
