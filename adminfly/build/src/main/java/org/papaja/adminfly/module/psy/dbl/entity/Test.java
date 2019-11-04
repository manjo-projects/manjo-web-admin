package org.papaja.adminfly.module.psy.dbl.entity;

import org.papaja.adminfly.commons.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static java.lang.String.format;

@Entity
@Table(name = "psy_tests")
public class Test extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return format("Test{name='%s', code='%s', id=%d}", name, code, id);
    }
}
