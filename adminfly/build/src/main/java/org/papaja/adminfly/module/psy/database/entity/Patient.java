package org.papaja.adminfly.module.psy.database.entity;

import org.papaja.adminfly.commons.dao.entity.api.AbstractEntity;
import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.PatientDetails;

import javax.persistence.*;
import java.sql.Timestamp;

import static java.lang.String.format;
import static org.papaja.adminfly.module.psy.tests.Gender.F;

@Entity
@Table(name = "PSY_PATIENTS")
public class Patient extends AbstractEntity implements PatientDetails {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "SEX", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "CREATED")
    private Timestamp created;

    @Column(name = "UPDATED")
    private Timestamp updated;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSexEmoji() {
        return gender.equals(F) ? "&#127825;" : "&#127820;";
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return format("Patient{name='%s', surname='%s', gender=%s, created=%s, updated=%s}",
                name, surname, gender, created, updated);
    }
}
