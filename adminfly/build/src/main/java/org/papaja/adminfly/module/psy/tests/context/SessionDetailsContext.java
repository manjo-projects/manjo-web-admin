package org.papaja.adminfly.module.psy.tests.context;

import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.PatientDetails;
import org.papaja.adminfly.module.psy.tests.SessionContext;
import org.papaja.adminfly.module.psy.tests.SessionDetails;

public class SessionDetailsContext extends TestContext implements SessionContext {

    private SessionDetails session;
    private PatientDetails patient;

    @Override
    public SessionDetails getSession() {
        return session;
    }

    @Override
    public void setSession(SessionDetails session) {
        this.session = session;
    }

    @Override
    public PatientDetails getPatient() {
        return patient;
    }

    @Override
    public void setPatient(PatientDetails patient) {
        this.patient = patient;
    }

    @Override
    public Gender getGender() {
        return hasPatient() ? getPatient().getGender() : null;
    }

    @Override
    public void setGender(Gender gender) {
        if (hasPatient()) {
            getPatient().setGender(gender);
        }
    }

}
