package org.papaja.adminfly.module.psy.tests.mmpi2;

import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.wizard.AbstractWizard;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;

import static java.lang.String.format;

public class WizardFactory {

    public Wizard<Answer> createWizard(Test test) {
        Wizard<Answer> wizard;

        switch (test) {
            case MMPI_566:
                wizard = new AbstractWizard<Answer>(1, 566) {}; break;
            case MMPI_71:
                wizard = new AbstractWizard<Answer>(1, 71) {}; break;
            case MMPI_377:
                wizard = new AbstractWizard<Answer>(1, 377) {}; break;
            default:
                throw new IllegalArgumentException(format("Cannot create wizard for '%s' test", test));
        }

        return wizard;
    }

}
