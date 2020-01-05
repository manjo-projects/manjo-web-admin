package org.papaja.adminfly.module.psy.tests.context;

import org.papaja.adminfly.module.psy.tests.*;

public class AbstractContext implements Context, PayloadContext, SessionContext {

    private final static RuntimeException UNSUPPORTED_OPERATION_EXCEPTION
            = new UnsupportedOperationException("Unsupported method call from thus context");

    private Gender gender;
    private Test   test;

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public Test getTest() {
        return test;
    }

    @Override
    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public PatientDetails getPatient() {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public void setPatient(PatientDetails patient) {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public Payload getPayload() {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public void setPayload(Payload payload) {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public SessionDetails getSession() {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public void setSession(SessionDetails session) {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }
}
