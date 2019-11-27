package org.papaja.adminfly.module.psy.dbl.repository;

import org.papaja.adminfly.commons.mvc.repository.AbstractRepository;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepository extends AbstractRepository<Patient> {

    @Override
    public Class<Patient> getReflection() {
        return Patient.class;
    }

}
