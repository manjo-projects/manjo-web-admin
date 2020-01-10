package org.papaja.adminfly.module.psy.tests.context;

public interface SessionContext extends SessionAware, PatientAware, Context {

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

    default boolean hasPatient() {
        return getPatient() != null;
    }

    default boolean hasSession() {
        return getSession() != null;
    }

}
