package org.papaja.adminfly.module.psy.tests.mmpi2;

import java.util.Map;

public interface PointsInterface {

    void increase(Scale scale);

    void decrease(Scale scale);

    int points(Scale scale);

    Map<Scale, Integer> points();

}
