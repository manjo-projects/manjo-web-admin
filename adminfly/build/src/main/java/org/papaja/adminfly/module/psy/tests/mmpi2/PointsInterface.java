package org.papaja.adminfly.module.psy.tests.mmpi2;

import java.util.Map;

public interface PointsInterface {

    void increase(ScaleInterface scale);

    void decrease(ScaleInterface scale);

    int points(ScaleInterface scale);

    Map<ScaleInterface, Integer> points();

}
