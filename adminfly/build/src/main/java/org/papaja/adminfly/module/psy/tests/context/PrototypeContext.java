package org.papaja.adminfly.module.psy.tests.context;

import org.papaja.adminfly.module.psy.tests.*;

public class PrototypeContext implements Context {

    private Gender         gender;
    private Test           test;
    private Payload        payload;
    private SessionDetails session;
    private PatientDetails patient;

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
    public Payload getPayload() {
        return payload;
    }

    @Override
    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public SessionDetails getSession() {
        return session;
    }

    @Override
    public void setSession(SessionDetails session) {
        this.session = session;
    }

    @Override
    public void setPatient(PatientDetails patient) {
        this.patient = patient;
    }

    @Override
    public PatientDetails getPatient() {
        return patient;
    }

}
