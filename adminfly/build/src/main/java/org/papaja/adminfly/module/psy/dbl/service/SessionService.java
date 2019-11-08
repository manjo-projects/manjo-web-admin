package org.papaja.adminfly.module.psy.dbl.service;

import org.papaja.adminfly.commons.service.AbstractService;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.Session;
import org.papaja.adminfly.module.psy.dbl.repository.SessionRepository;
import org.papaja.adminfly.module.psy.tests.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

@Service
public class SessionService extends AbstractService<Session, SessionRepository> {

    private static final String ENCRYPTOR_PASSWORD = "InnaPsy";

    private final SessionRepository repository;

    @Autowired
    public SessionService(SessionRepository repository) {
        this.repository = repository;
    }

    public TextEncryptor getEncryptor() {
        return Encryptors.text(ENCRYPTOR_PASSWORD, KeyGenerators.string().generateKey());
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
