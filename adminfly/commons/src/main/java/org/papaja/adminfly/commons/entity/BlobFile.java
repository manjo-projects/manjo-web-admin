package org.papaja.adminfly.commons.entity;

import org.papaja.adminfly.commons.entity.api.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;

import static java.lang.String.format;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "SHARED_FILES")
@DiscriminatorColumn(name = "D_TYPE")
abstract public class BlobFile extends AbstractEntity {

    @Column(name = "NAME", length = 64)
    private String name;

    @Column(name = "D_TYPE", length = 32, updatable = false, insertable = false, nullable = false)
    private String dType;

    @Lob
    @Column(name = "DATA", columnDefinition = "BLOB")
    private byte[] data;

    @Column(name = "MIME_TYPE", length = 32)
    private String mime;

    @Column(name = "IS_COMPRESSED", columnDefinition = "TINYINT(4)")
    private Boolean compressed;

    @Column(name = "ALGORITHM", length = 8)
    private String algorithm;

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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public Boolean getCompressed() {
        return compressed;
    }

    public void setCompressed(Boolean compressed) {
        this.compressed = compressed;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
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
        return format("BlobFile{dType='%s', name='%s', data=%s, mime='%s', compressed=%s, algorithm='%s', created=%s, updated=%s}",
                dType, name, format("BLOB[%d]", data.length), mime, compressed, algorithm, created, updated);
    }
}
