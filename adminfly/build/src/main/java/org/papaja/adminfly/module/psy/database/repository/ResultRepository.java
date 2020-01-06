package org.papaja.adminfly.module.psy.database.repository;

import org.papaja.adminfly.commons.dao.repository.AbstractRepository;
import org.papaja.adminfly.module.psy.database.entity.results.Result;
import org.springframework.stereotype.Repository;

@Repository
public class ResultRepository extends AbstractRepository<Result> {

    @Override
    public Class<Result> getReflection() {
        return Result.class;
    }

}
