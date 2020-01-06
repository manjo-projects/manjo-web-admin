package org.papaja.adminfly.module.psy.database.formatter;

import org.papaja.function.Formatter;

public class FormatterDelegate implements Formatter {

    private static final Formatter NULL_FORMATTER = value -> null;
    private              Formatter formatter      = NULL_FORMATTER;

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public Object format(Object value) {
        return formatter.format(value);
    }

}
