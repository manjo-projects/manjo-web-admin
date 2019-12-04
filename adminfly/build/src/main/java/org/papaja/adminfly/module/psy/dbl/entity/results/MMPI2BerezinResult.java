package org.papaja.adminfly.module.psy.dbl.entity.results;

import javax.persistence.*;

import static java.lang.String.format;

@Entity
@Table(name = "PSY_RESULTS_MMPI2_BEREZIN")
@PrimaryKeyJoinColumn(name = "RESULT_ID")
@DiscriminatorValue("MMPI2_BEREZIN")
public class MMPI2BerezinResult extends MMPI2Result {

}
