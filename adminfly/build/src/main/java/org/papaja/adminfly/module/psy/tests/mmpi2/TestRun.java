package org.papaja.adminfly.module.psy.tests.mmpi2;

import org.papaja.adminfly.module.psy.tests.mmpi2.model.Scale;

public class TestRun {

    public static void main(String[] args) {
//        System.out.println(Scale.K.HP.calculate(71));

        float a = 61f;
        float b = 70f;

        float value = (b - a) / 5f;

        System.out.println(value);

        float sequence = a;

        for (; sequence <= b; sequence += value) {
            System.out.println(sequence);
        }

    }

}
