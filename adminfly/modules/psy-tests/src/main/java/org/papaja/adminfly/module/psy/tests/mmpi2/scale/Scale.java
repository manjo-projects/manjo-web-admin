package org.papaja.adminfly.module.psy.tests.mmpi2.scale;


public class Scale {

    protected int[] ratio;
    protected Type  name;

    public Scale(int[] ratio, Type name) {
        this.ratio = ratio;
        this.name = name;
    }

    public int getRatio(int points) {
        int ratio = 0;

        for (int i = 0; i < points; i++) {
            ratio += this.ratio[i];
        }

        return ratio;
    }

    public Type getName() {
        return name;
    }

    public enum Type {
        SCALE_A,
        SCALE_L,
        SCALE_F,
        SCALE_K,
        SCALE_0,
        SCALE_1,
        SCALE_2,
        SCALE_3,
        SCALE_4,
        SCALE_5,
        SCALE_6,
        SCALE_7,
        SCALE_8,
        SCALE_9
    }

}
