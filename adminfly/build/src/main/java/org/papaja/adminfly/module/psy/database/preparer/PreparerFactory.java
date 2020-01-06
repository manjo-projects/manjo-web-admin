package org.papaja.adminfly.module.psy.database.preparer;

import org.papaja.adminfly.module.psy.commons.function.Preparer;
import org.papaja.adminfly.module.psy.tests.Context;

public class PreparerFactory {

    public static Preparer createPreparer(Context context) {
        PreparerWrapper preparer = new PreparerWrapper();

        switch (context.getTest()) {
            case MMPI_377:
            case MMPI_71:
            case MMPI_566:
                preparer.setPreparer(new MMPIResultPreparer(context.getGender()));
        }

        return preparer;
    }

}
