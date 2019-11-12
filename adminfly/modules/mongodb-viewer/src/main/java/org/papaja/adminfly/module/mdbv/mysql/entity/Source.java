package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.commons.entity.api.AbstractEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "MDBV_SOURCES")
public class Source extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DB")
    private String database;

    @Column(name = "COLLECTION")
    private String collection;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "source")
    private Collection<Row> rows;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public Collection<Row> getRows() {
        return rows;
    }

    public void setRows(Collection<Row> rows) {
        this.rows = rows;
    }

}
