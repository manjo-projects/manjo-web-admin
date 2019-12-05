package org.papaja.adminfly.module.psy.tests.mmpi2;

public interface QuestionsInterface {

    Scale[] getScales(int question, Answer answer);

    boolean hasScales(int question, Answer answer);

}
