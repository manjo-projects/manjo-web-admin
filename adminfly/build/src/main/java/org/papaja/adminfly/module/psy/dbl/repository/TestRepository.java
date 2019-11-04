package org.papaja.adminfly.module.psy.dbl.repository;

import org.papaja.adminfly.commons.repository.AbstractRepository;
import org.papaja.adminfly.module.psy.dbl.entity.Test;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository extends AbstractRepository<Test> {

    @Override
    public Class<Test> getReflection() {
        return Test.class;
    }

}
