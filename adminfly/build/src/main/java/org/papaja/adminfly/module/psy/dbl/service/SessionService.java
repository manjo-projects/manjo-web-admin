package org.papaja.adminfly.module.psy.dbl.service;

import org.papaja.adminfly.commons.service.AbstractService;
import org.papaja.adminfly.module.psy.commons.crypto.CryptoUtils;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.Session;
import org.papaja.adminfly.module.psy.dbl.repository.SessionRepository;
import org.papaja.adminfly.module.psy.tests.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService extends AbstractService<Session, SessionRepository> {

    private final SessionRepository repository;

    @Autowired
    public SessionService(SessionRepository repository) {
        this.repository = repository;
    }

    public CryptoUtils getEncryptor() {
        return CryptoUtils.INSTANCE;
    }

    public void newSession(Patient patient, Test test) {
        Session session = new Session();

        session.setPatient(patient);
        session.setTest(test);
        session.setActive(true);

        merge(session);
    }

    @Override
    public SessionRepository getRepository() {
        return repository;
    }

    @Override
    public Session get() {
        return new Session();
    }

}
