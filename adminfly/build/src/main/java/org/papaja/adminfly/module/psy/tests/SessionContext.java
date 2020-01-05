package org.papaja.adminfly.module.psy.tests;

import static org.papaja.adminfly.module.psy.tests.Context.UNSUPPORTED_OPERATION_EXCEPTION;

public interface SessionContext extends SessionAware, PatientAware {

    String NAME = PayloadContext.class.getCanonicalName();

    default void setSession(SessionDetails session) {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(NAME, "setSession");
    }

    @Override
    default SessionDetails getSession() {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(NAME, "getSession");
    }

    default void setPatient(PatientDetails patient) {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(NAME, "setPatient");
    }

    @Override
    default PatientDetails getPatient() {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(NAME, "getPatient");
    }
}
