package org.papaja.adminfly.module.psy.database.entity;

import org.papaja.adminfly.commons.dao.entity.api.AbstractEntity;
import org.papaja.adminfly.module.psy.tests.Gender;

import javax.persistence.*;
import java.sql.Timestamp;

import static java.lang.String.format;
import static org.papaja.adminfly.module.psy.tests.Gender.F;

@Entity
@Table(name = "PSY_PATIENTS")
public class Patient extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "SEX", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(name = "CREATED")
    private Timestamp created;

    @Column(name = "UPDATED")
    private Timestamp updated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public String getSexEmoji() {
        return sex.equals(F) ? "&#127825;" : "&#127820;";
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
        return format("Patient{name='%s', surname='%s', sex=%s, created=%s, updated=%s}",
                name, surname, sex, created, updated);
    }
}
