package org.papaja.adminfly.module.psy.tests.mmpi2;

import org.papaja.adminfly.module.psy.tests.mmpi2.scale.Scale;
import org.papaja.adminfly.module.psy.tests.mmpi2.scale.Scales;

public class Run {

    public static void main(String[] args) {

        Scale.Type type   = Scale.Type.SCALE_1;
        int        offset = 24;
        int value;

//        for (int i = 0; i <= 46; i++) {
//value = Scales.FEMALE.getScale(type).getRatio(i) + offset;
//            System.out.println(
//value
//            );
////            System.out.printf("%d: %d%n", i, Scales.FEMALE.getScale(type).getRatio(i) + offset);
//        }

//        System.out.printf("%d: %d%n", 22, Scales.FEMALE.getScale(type).getRatio(22) + offset);

        float k = 0f;

        System.out.println(k);

        for (int i = 0; i <= 70; i++) {
            k += (1F / 71F);
            System.out.println(
                    Math.round(25 + (i + k))
            );
        }

    }



}
