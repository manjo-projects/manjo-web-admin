package org.papaja.adminfly.module.psy.dbl.entity.results;

import javax.persistence.*;

import static java.lang.String.format;

@Entity
@Table(name = "PSY_RESULTS_MMPI_Q566")
@PrimaryKeyJoinColumn(name = "RESULT_ID")
@DiscriminatorValue("MMPI_566")
public class MMPI566Result extends AbstractMMPIResult {

}
