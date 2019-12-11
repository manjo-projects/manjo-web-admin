package org.papaja.adminfly.module.psy.tests.MMPI;

import java.util.EnumMap;
import java.util.Map;

public class Points implements PointsInterface {

    private Map<Scale, Integer> points = new EnumMap<>(Scale.class);

    public Points() {
        for (Scale scale : Scale.values()) {
            points.put(scale, 0);
        }
    }

    @Override
    public void increase(Scale scale) {
        points.put(scale, points.get(scale) + 1);
    }

    @Override
    public void decrease(Scale scale) {
        points.put(scale, points.get(scale) - 1);
    }

    @Override
    public int points(Scale scale) {
        return points.get(scale);
    }

    @Override
    public Map<Scale, Integer> points() {
        return points;
    }

}
