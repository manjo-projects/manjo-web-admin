package org.papaja.adminfly.module.psy.tests;

import org.papaja.adminfly.module.psy.tests.MMPI.Gender;

public interface Context extends TestAware {

    Gender getGender();

    UserDetails getUsedDetails();

}
