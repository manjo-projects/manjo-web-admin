package org.papaja.adminfly.module.psy.tests.mmpi2.scale;

import java.util.EnumMap;

import static org.papaja.adminfly.module.psy.tests.mmpi2.scale.Scale.Type.*;

public enum Scales {

    MALE(new Set() {{
        add(new Scale(new int[0], SCALE_0));
    }}),

    FEMALE(new Set() {{
        add(new Scale(new int[] {
                2, 2, 2, 3, 2, // 0-5
                2, 2, 2, 2, 2, // 5-10
                2, 2, 2, 2, 2, // 10-15
                1, 2, 2, 2, 2, // 15-20
                2, 2, 2, 2, 2, // 20-25
                2, 2, 2, 2, 2, // 25-30
                2, 2, 3, 1, 2, // 30-35
                2, 2, 3, 1, 3, // 35-40
                1, 1, 1, 1, 1, // 40-45
                1,             // 46-..
        }, SCALE_1));
    }});

    private EnumMap<Scale.Type, Scale> scales;

    Scales(EnumMap<Scale.Type, Scale> scales) {
        this.scales = scales;
    }

    public EnumMap<Scale.Type, Scale> getScales() {
        return scales;
    }

    public Scale getScale(Scale.Type name) {
        return scales.get(name);
    }

    private static class Set extends EnumMap<Scale.Type, Scale> {

        public Set() {
            super(Scale.Type.class);
        }

        public void add(Scale scale) {
            put(scale.getName(), scale);
        }

    }

}
