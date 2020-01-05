package org.papaja.adminfly.module.psy.database.entity;

import org.papaja.adminfly.commons.dao.entity.api.AbstractEntity;
import org.papaja.adminfly.module.psy.tests.SessionDetails;
import org.papaja.adminfly.module.psy.tests.Test;

import javax.persistence.*;

import static java.lang.String.format;
import static java.lang.String.valueOf;

@Entity
@Table(name = "PSY_SESSIONS")
public class Session extends AbstractEntity implements SessionDetails {

    @Column(name = "SESSION_ID", columnDefinition = "VARCHAR(16)")
    private String sessionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @Column(name = "TEST", columnDefinition = "VARCHAR(16)")
    @Enumerated(EnumType.STRING)
    private Test test;

    @Column(name = "ACTIVE", columnDefinition = "TINYINT(1)")
    private Boolean active;

    @Override
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getStringId() {
        return valueOf(id);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return format("Session{patient=%s, id=%d, test=%s, active=%s}",
                patient, id, test, active);
    }
}
