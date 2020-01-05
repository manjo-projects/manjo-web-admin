package org.papaja.adminfly.module.psy.tests.context;

import org.papaja.adminfly.module.psy.tests.*;

public class ComplexContext<PayloadType> implements SessionContext, PayloadContext<PayloadType> {

    private SessionDetailsContext           sessionContext;
    private PayloadDataContext<PayloadType> payloadContext;

    public ComplexContext() {
        sessionContext = new SessionDetailsContext();
        payloadContext = new PayloadDataContext<>();
    }

    @Override
    public Gender getGender() {
        return sessionContext.getGender();
    }

    @Override
    public void setGender(Gender gender) {
        sessionContext.setGender(gender);
    }

    @Override
    public Test getTest() {
        return sessionContext.getTest();
    }

    @Override
    public void setTest(Test test) {
        sessionContext.setTest(test);
    }

    @Override
    public Payload<PayloadType> getPayload() {
        return payloadContext.getPayload();
    }

    @Override
    public void setPayload(Payload<PayloadType> payload) {
        payloadContext.setPayload(payload);
    }

    @Override
    public SessionDetails getSession() {
        return sessionContext.getSession();
    }

    @Override
    public void setSession(SessionDetails session) {
        sessionContext.setSession(session);
    }

    @Override
    public PatientDetails getPatient() {
        return sessionContext.getPatient();
    }

    @Override
    public void setPatient(PatientDetails patient) {
        sessionContext.setPatient(patient);
    }
}
