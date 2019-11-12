package org.papaja.adminfly.module.psy.dbl.entity.results;

import org.papaja.adminfly.commons.entity.api.EntityInterface;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.tests.Test;

import javax.persistence.*;

import java.util.Objects;

import static java.lang.String.format;

@Entity
@MappedSuperclass
public abstract class Result implements EntityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Integer id;

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

    public Boolean isNew() {
        return Objects.isNull(getId());
    }

    public Boolean isOld() {
        return !isNew();
    }

    @Override
    public String toString() {
        return format("Results{test=%s, patient=%s}", test, patient);
    }
}
