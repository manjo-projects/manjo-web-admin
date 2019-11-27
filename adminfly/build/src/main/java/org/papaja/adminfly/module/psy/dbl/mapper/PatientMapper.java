package org.papaja.adminfly.module.psy.dbl.mapper;

import org.papaja.adminfly.commons.mvc.mapper.AbstractMapper;
import org.papaja.adminfly.module.psy.dbl.dto.PatientDto;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;

import java.sql.Timestamp;
import java.time.Instant;

import static org.papaja.adminfly.module.psy.tests.mmpi2.data.Sex.valueOf;
import static org.springframework.util.StringUtils.capitalize;

public class PatientMapper extends AbstractMapper<PatientDto, Patient> {

    @Override
    public void accept(PatientDto dto, Patient patient) {
        Timestamp timestamp = Timestamp.from(Instant.now());

        patient.setName(capitalize(dto.getName().toLowerCase()));
        patient.setSurname(capitalize(dto.getSurname().toLowerCase()));
        patient.setSex(valueOf(dto.getSex()));

        if (patient.isNew()) {
            patient.setCreated(timestamp);
        }

        patient.setUpdated(timestamp);
    }

    @Override
    public Patient get() {
        return new Patient();
    }
}
