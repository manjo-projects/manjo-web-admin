package org.papaja.adminfly.module.psy.tests.mmpi2.result;

import org.papaja.adminfly.module.psy.tests.mmpi2.model.Scale;

import java.util.EnumMap;

public class Points extends EnumMap<Scale, Integer> {

    {
        for (Scale scale : Scale.values()) {
            put(scale, 0);
        }
    }

    public Points() {
        super(Scale.class);
    }

    public void getTRate(Scale scale) {
//        return scale.getget(scale)
    }

}
