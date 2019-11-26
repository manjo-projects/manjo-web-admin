package org.papaja.adminfly.module.psy.tests.mmpi2.model;

import static java.lang.Math.round;

public enum Scale {

    SCALE_A("?", 'A'),
    SCALE_L("L", 'L'),
    SCALE_F("F", 'F'),
    SCALE_K("K", '1'),
    SCALE_1("Hs", K.HP, '1'),
    SCALE_2("D", '2'),
    SCALE_3("Hy", '3'),
    SCALE_4("Pd", K.QP, '4'),
    SCALE_5_F("Mf-F", true, '5'),
    SCALE_5_M("Mf-M", true, '5'),
    SCALE_6("Pa", '6'),
    SCALE_7("Pt", K.OP, '7'),
    SCALE_8("Sc", K.OP, '8'),
    SCALE_9("Ma", K.FP, '9'),
    SCALE_0("Si", '0');

    private K       k;
    private boolean inverted;
    private String  name;
    private char    code;

    Scale(String name, K k, boolean inverted, char code) {
        this.name = name;
        this.k = k;
        this.inverted = inverted;
        this.code = code;
    }

    Scale(String name, K k, char code) {
        this(name, k, false, code);
    }

    Scale(String name, boolean inverted, char code) {
        this(name, null, inverted, code);
    }

    Scale(String name, char code) {
        this(name, null, false, code);
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

    public char code() {
        return code;
    }

    public enum K {

        HP(0.5f),
        QP(0.4f),
        FP(0.2f),
        OP(1.0f);

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