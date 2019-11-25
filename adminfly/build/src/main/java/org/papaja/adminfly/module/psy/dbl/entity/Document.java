package org.papaja.adminfly.module.psy.dbl.entity;

import org.papaja.adminfly.commons.entity.BlobFile;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PSY_DOCUMENT")
public class Document extends BlobFile {

}
