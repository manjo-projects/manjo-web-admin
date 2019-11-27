package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.commons.mvc.entity.api.AbstractEntity;
import org.papaja.converter.Format;

import javax.persistence.*;

@Entity
@Table(name = "MDBV_ROWS")
public class Row extends AbstractEntity {

    @Column(name = "PATH")
    private String path;

    @Column(name = "d_type", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "COLUMN_PREVIEW", columnDefinition = "TINYINT(1)")
    private Boolean preview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOURCE_ID")
    private Source source;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Format type;

    @Column(name = "POSITION")
    private Integer position;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getPreview() {
        return preview;
    }

    public void setPreview(Boolean preview) {
        this.preview = preview;
    }

    public boolean isFull() {
        return Status.F.equals(status);
    }

    public boolean isShort() {
        return !isFull();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Format getType() {
        return type;
    }

    public void setType(Format type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public enum Status {S, F}

}
