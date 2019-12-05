package org.papaja.adminfly.module.psy.tests.mmpi2;

import static java.lang.Math.round;

public enum Scale {

    SCALE_L("L"),
    SCALE_F("F"),
    SCALE_K("K"),
    SCALE_1("Hs", K.HP),
    SCALE_2("D"),
    SCALE_3("Hy"),
    SCALE_4("Pd", K.QP),
    SCALE_5_F("Mf-F", true),
    SCALE_5_M("Mf-M", true),
    SCALE_6("Pa"),
    SCALE_7("Pt", K.OP),
    SCALE_8("Sc", K.OP),
    SCALE_9("Ma", K.FP),
    SCALE_0("Si");

    private K       k;
    private boolean inverted;
    private String  name;
    // todo
    private Sex     sex;

    Scale(String name, K k, boolean inverted) {
        this.name = name;
        this.k = k;
        this.inverted = inverted;
    }

    Scale(String name, K k) {
        this(name, k, false);
    }

    Scale(String name, boolean inverted) {
        this(name, null, inverted);
    }

    Scale(String name) {
        this(name, null, false);
    }

    public boolean hasK() {
        return k != null;
    }

    public K getK() {
        return k;
    }

    public boolean isInverted() {
        return inverted;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return getName().toUpperCase();
    }

    public Sex sex() {
        return sex;
    }

    public void sex(Sex sex) {
        this.sex = sex;
    }

    public enum K {

        HP(0.5f),
        QP(0.4f),
        FP(0.2f),
        OP(1.0f);

        // todo
        private static final float RATIO_CORRECTION = 10f;
        private static final float K_GRADUATION     = 31.5f;
        private static final float T_GRADUATION     = 120f - RATIO_CORRECTION;
        private              float factor;

        K(float factor) {
            this.factor = (T_GRADUATION / K_GRADUATION) / factor;
        }

        public int calculate(float rate) {
            return round((rate - RATIO_CORRECTION) / factor);
        }

        public int subtract(float rate) {
            return round(rate * factor);
        }

    }

}