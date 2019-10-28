package org.papaja.adminfly.module.psy.tests.mmpi2;

import org.papaja.adminfly.module.psy.tests.mmpi2.answer.Answer;
import org.papaja.adminfly.module.psy.tests.mmpi2.answer.FemaleAnswers;

public class Run {

    public static void main(String[] args) {
        FemaleAnswers answers = new FemaleAnswers();
        answers.getAnswers().forEach((integer, answer) -> {
            if (answer.equals(Answer.FALSE)) {
                System.out.print(integer + ", ");
            }
//            System.out.println(answer);
        });
    }

}
