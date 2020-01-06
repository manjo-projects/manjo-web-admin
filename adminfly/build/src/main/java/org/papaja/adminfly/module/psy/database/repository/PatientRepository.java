package org.papaja.adminfly.module.psy.database.repository;

import org.papaja.adminfly.commons.dao.repository.AbstractRepository;
import org.papaja.adminfly.module.psy.database.entity.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepository extends AbstractRepository<Patient> {

    @Override
    public Class<Patient> getReflection() {
        return Patient.class;
    }

}
