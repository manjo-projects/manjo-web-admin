package org.papaja.adminfly.module.psy.database.entity.results.MMPI;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PSY_RESULTS_MMPI_Q377")
@PrimaryKeyJoinColumn(name = "RESULT_ID")
@DiscriminatorValue("MMPI_377")
public class MMPI377Result extends AbstractMMPIResult {

}
