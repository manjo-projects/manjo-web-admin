package org.papaja.adminfly.module.psy.dbl.entity;

import org.papaja.adminfly.commons.dao.entity.api.AbstractEntity;
import org.papaja.adminfly.module.psy.tests.Test;

import javax.persistence.*;

import static java.lang.String.format;
import static java.lang.String.valueOf;

@Entity
@Table(name = "PSY_SESSIONS")
public class Session extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @Column(name = "TEST", columnDefinition = "VARCHAR(16)")
    @Enumerated(EnumType.STRING)
    private Test test;

    @Column(name = "ACTIVE", columnDefinition = "TINYINT(1)")
    private Boolean active;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return format("Session{patient=%s, id=%d, test=%s, active=%s}",
                patient, id, test, active);
    }
}
