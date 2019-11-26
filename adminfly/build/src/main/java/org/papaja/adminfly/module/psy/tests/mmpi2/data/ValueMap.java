package org.papaja.adminfly.module.psy.tests.mmpi2.data;

import org.papaja.tuple.Pair;

import java.util.EnumMap;
import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.mmpi2.data.Scale.*;
import static org.papaja.adminfly.module.psy.tests.mmpi2.data.Sex.F;
import static org.papaja.adminfly.module.psy.tests.mmpi2.data.Sex.M;

// [SEX][SCALE] = [INDEX,SIGMA]
public enum ValueMap {
    MAP;

    private static final Map<Sex, Map<Scale, Value>> VALUES;

    static {
        Map<Scale, Value> F_VALUES = new EnumMap<>(Scale.class);
        Map<Scale, Value> M_VALUES = new EnumMap<>(Scale.class);

        VALUES = new EnumMap<>(Sex.class);

        VALUES.put(F, F_VALUES);
        VALUES.put(M, M_VALUES);

        F_VALUES.put(SCALE_L, new Value(4.2f, 2.9f));
        F_VALUES.put(SCALE_F, new Value(2.76f, 4.67f));
        F_VALUES.put(SCALE_K, new Value(12.1f, 5.4f));
        F_VALUES.put(SCALE_1, new Value(12.9f, 4.83f));
        F_VALUES.put(SCALE_2, new Value(18.9f, 5.0f));
        F_VALUES.put(SCALE_3, new Value(18.66f, 5.38f));
        F_VALUES.put(SCALE_4, new Value(18.68f, 4.11f));
        F_VALUES.put(SCALE_5_F, new Value(36.7f, 4.67f));
        F_VALUES.put(SCALE_6, new Value(7.9f, 3.4f));
        F_VALUES.put(SCALE_7, new Value(25.07f, 6.1f));
        F_VALUES.put(SCALE_8, new Value(22.73f, 6.36f));
        F_VALUES.put(SCALE_9, new Value(17.0f, 4.06f));
        F_VALUES.put(SCALE_0, new Value(25.0f, 10.0f));

        M_VALUES.put(SCALE_L, new Value(4.2f, 2.9f));
        M_VALUES.put(SCALE_F, new Value(2.76f, 4.67f));
        M_VALUES.put(SCALE_K, new Value(12.1f, 5.4f));
        M_VALUES.put(SCALE_1, new Value(11.1f, 3.9f));
        M_VALUES.put(SCALE_2, new Value(16.6f, 4.11f));
        M_VALUES.put(SCALE_3, new Value(16.46f, 5.4f));
        M_VALUES.put(SCALE_4, new Value(18.68f, 4.11f));
        M_VALUES.put(SCALE_5_M, new Value(20.46f, 5.0f));
        M_VALUES.put(SCALE_6, new Value(7.9f, 3.4f));
        M_VALUES.put(SCALE_7, new Value(23.06f, 5.0f));
        M_VALUES.put(SCALE_8, new Value(21.96f, 5.0f));
        M_VALUES.put(SCALE_9, new Value(17.0f, 4.06f));
        M_VALUES.put(SCALE_0, new Value(25.0f, 10.0f));
    }

    public Map<Scale, Value> getValues(Sex sex) {
        return VALUES.get(sex);
    }

    public static class Value extends Pair<Float, Float> {

        public Value(Float index, Float sigma) {
            super(index, sigma);
        }

        public float getIndex() {
            return getA();
        }

        public float getSigma() {
            return getB();
        }

    }

}
