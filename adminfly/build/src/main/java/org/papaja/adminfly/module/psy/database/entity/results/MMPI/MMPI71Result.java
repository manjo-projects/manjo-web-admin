package org.papaja.adminfly.module.psy.database.entity.results.MMPI;

import javax.persistence.*;

import static java.lang.String.format;

@Entity
@Table(name = "PSY_RESULTS_MMPI_Q71")
@PrimaryKeyJoinColumn(name = "RESULT_ID")
@DiscriminatorValue("MMPI_71")
public class MMPI71Result extends AbstractMMPIResult {

}
