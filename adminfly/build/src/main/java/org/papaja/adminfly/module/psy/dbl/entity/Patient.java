package org.papaja.adminfly.module.psy.dbl.entity;

import org.papaja.adminfly.commons.entity.AbstractEntity;
import org.papaja.adminfly.module.psy.tests.mmpi2.model.Sex;

import javax.persistence.*;
import java.sql.Timestamp;

import static java.lang.String.format;

@Entity
@Table(name = "psy_patients")
public class Patient extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "sex", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "updated")
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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
