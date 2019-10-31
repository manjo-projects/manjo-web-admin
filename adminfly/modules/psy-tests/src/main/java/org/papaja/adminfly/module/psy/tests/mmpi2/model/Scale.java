package org.papaja.adminfly.module.psy.tests.mmpi2.model;

public enum Scale {

    SCALE_A,
    SCALE_L,
    SCALE_F,
    SCALE_K,
    SCALE_1,
    SCALE_2,
    SCALE_3,
    SCALE_4,
    SCALE_5_F, SCALE_5_M,
    SCALE_6,
    SCALE_7,
    SCALE_8,
    SCALE_9,
    SCALE_0;

    private double[] rates;

    Scale(double... rates) {
        this.rates = rates;
    }

    Scale() { this(0D); }

    public double getRate(int points) {
        return rates[points];
    }

}
