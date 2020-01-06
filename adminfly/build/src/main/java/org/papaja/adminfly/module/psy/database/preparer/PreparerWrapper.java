package org.papaja.adminfly.module.psy.database.preparer;

import org.papaja.adminfly.module.psy.commons.function.Preparer;
import org.papaja.adminfly.module.psy.commons.function.Value;

public class PreparerWrapper implements Preparer {

    private static final Preparer NULL_PREPARER = value -> null;
    private              Preparer preparer      = NULL_PREPARER;

    public void setPreparer(Preparer preparer) {
        this.preparer = preparer;
    }

    @Override
    public Value<?> prepare(Object value) {
        return preparer.prepare(value);
    }

}
