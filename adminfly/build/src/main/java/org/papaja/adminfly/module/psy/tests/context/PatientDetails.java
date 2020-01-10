package org.papaja.adminfly.module.psy.tests.context;

import org.papaja.adminfly.module.psy.tests.Gender;

public interface PatientDetails {

    String getName();

    String getSurname();

    Gender getGender();

    void setName(String name);

    void setSurname(String surname);

    void setGender(Gender gender);

}
