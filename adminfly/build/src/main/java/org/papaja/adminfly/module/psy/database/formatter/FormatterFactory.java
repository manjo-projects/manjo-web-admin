package org.papaja.adminfly.module.psy.database.formatter;

import org.papaja.adminfly.module.psy.tests.Context;
import org.papaja.function.Formatter;

public class FormatterFactory {

    public static Formatter createFormatter(Context context) {
        FormatterDelegate formatter = new FormatterDelegate();

        switch (context.getTest()) {
            case MMPI_377:
            case MMPI_71:
            case MMPI_566:
                formatter.setFormatter(new MMPIResultFormatter(context.getGender()));
        }

        return formatter;
    }

}
