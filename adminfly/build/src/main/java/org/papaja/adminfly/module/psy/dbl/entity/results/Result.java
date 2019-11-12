package org.papaja.adminfly.module.psy.dbl.entity.results;

import org.papaja.adminfly.commons.entity.AbstractEntity;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.tests.Test;

import javax.persistence.*;

import static java.lang.String.format;

@MappedSuperclass
public abstract class Result extends AbstractEntity {

    @Column(name = "TEST", columnDefinition = "VARCHAR(16)")
    @Enumerated(EnumType.STRING)
    private Test test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return format("Results{test=%s, patient=%s}", test, patient);
    }
}
