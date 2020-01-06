package org.papaja.adminfly.module.psy.database.preparer;

import org.papaja.adminfly.module.psy.commons.function.Preparer;
import org.papaja.adminfly.module.psy.tests.Context;
import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.Test;

public class PreparerFactory {

    public static Preparer createPreparer(Test test, Gender gender) {
        PreparerWrapper preparer = new PreparerWrapper();

        switch (test) {
            case MMPI_377:
            case MMPI_71:
            case MMPI_566:
                preparer.setPreparer(new MMPIResultPreparer(gender));
        }

        return preparer;
    }

}
