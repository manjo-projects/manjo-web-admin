package org.papaja.adminfly.module.kv.entity;

import org.papaja.adminfly.commons.entity.api.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "KV_VALUES")
public class KeyValue extends AbstractEntity {

    @Column(name = "NAME")
    private String key;

    @Column(name = "VALUE")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("KeyValue{key='%s', value='%s'}", key, value);
    }
}
