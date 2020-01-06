package org.papaja.adminfly.module.psy.database.entity.results;

import javax.persistence.*;

import static java.lang.String.format;

@Entity
@Table(name = "PSY_RESULTS_SAMPLE")
@PrimaryKeyJoinColumn(name = "RESULT_ID")
@DiscriminatorValue("SAMPLE")
public class SampleResult extends Result {

    @Column(name = "KEY")
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
        return format("SampleResult{key='%s', value='%s'}", key, value);
    }
}
