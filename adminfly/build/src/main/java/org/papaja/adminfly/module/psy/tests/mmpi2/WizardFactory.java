package org.papaja.adminfly.module.psy.tests.mmpi2;

import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.wizard.AbstractWizard;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;

import java.util.EnumMap;
import java.util.Map;

import static java.lang.String.format;
import static org.papaja.adminfly.module.psy.tests.Test.*;

public class WizardFactory {

    private static final Map<Test, Wizard<Answer>> INSTANCES = new EnumMap<>(Test.class);

    static {
        INSTANCES.put(MMPI_566, new AbstractWizard<Answer>(1, 566) {});
        INSTANCES.put(MMPI_71, new AbstractWizard<Answer>(1, 71) {});
        INSTANCES.put(MMPI_377, new AbstractWizard<Answer>(1, 377) {});
    }

    public Wizard<Answer> createWizard(Test test) {
        Wizard<Answer> wizard;

        if (!INSTANCES.containsKey(test)) {
            throw new IllegalArgumentException(format("Cannot create wizard for '%s' test", test));
        } else {
            wizard = INSTANCES.get(test);
        }

        return wizard;
    }

}
