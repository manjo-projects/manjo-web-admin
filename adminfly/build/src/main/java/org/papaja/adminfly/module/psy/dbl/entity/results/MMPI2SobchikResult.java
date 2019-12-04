package org.papaja.adminfly.module.psy.dbl.entity.results;

import javax.persistence.*;

import static java.lang.String.format;

@Entity
@Table(name = "PSY_RESULTS_MMPI2_SOBCHIK")
@PrimaryKeyJoinColumn(name = "RESULT_ID")
@DiscriminatorValue("MMPI2_SOBCHIK")
public class MMPI2SobchikResult extends MMPI2Result {

}
