package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.tests.MMPI.answers.Q377Answers;
import org.papaja.adminfly.module.psy.tests.MMPI.answers.Q566Answers;
import org.papaja.adminfly.module.psy.tests.MMPI.answers.Q71Answers;
import org.papaja.adminfly.module.psy.tests.Test;

import static java.lang.String.format;

public class AnswersFactory {

    public static Answers createAnswers(Test test) {
        switch (test) {
            case MMPI_71:
                return new Q71Answers();
            case MMPI_377:
                return new Q377Answers();
            case MMPI_566:
                return new Q566Answers();
            default:
                throw new IllegalArgumentException(format("unable to get answers map for '%s' test", test));
        }
    }

}
