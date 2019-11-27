package org.papaja.adminfly.module.psy.dbl.service;

import org.papaja.adminfly.commons.mvc.service.AbstractService;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends AbstractService<Patient, PatientRepository> {

    private final PatientRepository repository;

    @Autowired
    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientRepository getRepository() {
        return repository;
    }

    @Override
    public Patient get() {
        return new Patient();
    }

}
