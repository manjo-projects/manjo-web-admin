package org.papaja.adminfly.module.psy.dbl.entity;

import org.papaja.adminfly.commons.dao.entity.BlobFile;

import javax.persistence.*;

@Entity
@Table(name = "PSY_DOCUMENT")
@PrimaryKeyJoinColumn(name = "RESULT_ID")
@DiscriminatorValue(value = "PSY_DOCUMENT")
public class Document extends BlobFile {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
