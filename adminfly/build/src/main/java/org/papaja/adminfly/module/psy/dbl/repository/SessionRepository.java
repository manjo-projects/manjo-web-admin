package org.papaja.adminfly.module.psy.dbl.repository;

import org.papaja.adminfly.commons.repository.AbstractRepository;
import org.papaja.adminfly.module.psy.dbl.entity.Session;
import org.springframework.stereotype.Repository;

@Repository
public class SessionRepository extends AbstractRepository<Session> {

    @Override
    public Class<Session> getReflection() {
        return Session.class;
    }

}
