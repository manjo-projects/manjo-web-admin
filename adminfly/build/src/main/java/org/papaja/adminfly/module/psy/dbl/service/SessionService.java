package org.papaja.adminfly.module.psy.dbl.service;

import org.papaja.adminfly.commons.service.AbstractService;
import org.papaja.adminfly.module.psy.commons.crypto.Crypto;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.Session;
import org.papaja.adminfly.module.psy.dbl.repository.SessionRepository;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class SessionService extends AbstractService<Session, SessionRepository> {

    private final SessionRepository repository;

    @Autowired
    public SessionService(SessionRepository repository) {
        this.repository = repository;
    }

    public Crypto getEncryptor() {
        return Crypto.INSTANCE;
    }

    public void newSession(Patient patient, Test test) {
        Session session = new Session();

        session.setPatient(patient);
        session.setTest(test);
        session.setActive(true);

        merge(session);
    }

    public List<Session> getSessions(Patient patient) {
        return repository.getList(repository.getConsumer(asList(
                new Pair<>("patient", patient),
                new Pair<>("active", true)
        )).after((builder, query, root) -> query.orderBy(builder.asc(root.get("id")))));
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
