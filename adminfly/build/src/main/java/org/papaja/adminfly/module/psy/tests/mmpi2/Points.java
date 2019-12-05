package org.papaja.adminfly.module.psy.tests.mmpi2;

import java.util.EnumMap;
import java.util.Map;

public class Points implements PointsInterface {

    private Map<ScaleInterface, Integer> points = new EnumMap<>(Scale.class);

    public Points() {
        for (ScaleInterface scale : Scale.values()) {
            points.put(scale, 0);
        }
    }

    @Override
    public void increase(ScaleInterface scale) {
        points.put(scale, points.get(scale) + 1);
    }

    @Override
    public void decrease(ScaleInterface scale) {
        points.put(scale, points.get(scale) - 1);
    }

    @Override
    public int points(ScaleInterface scale) {
        return points.get(scale);
    }

    @Override
    public Map<ScaleInterface, Integer> points() {
        return points;
    }

}
