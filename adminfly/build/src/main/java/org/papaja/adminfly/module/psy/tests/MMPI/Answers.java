package org.papaja.adminfly.module.psy.tests.MMPI;

public interface Answers {

    Scale[][][] getMap();

    Scale[] getScales(int question, Answer answer);

    boolean hasScales(int question, Answer answer);

}
