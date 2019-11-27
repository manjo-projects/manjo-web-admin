package org.papaja.adminfly.module.psy.dbl.repository;

import org.papaja.adminfly.commons.mvc.repository.AbstractRepository;
import org.papaja.adminfly.module.psy.dbl.entity.results.Result;
import org.springframework.stereotype.Repository;

@Repository
public class ResultRepository extends AbstractRepository<Result> {

    @Override
    public Class<Result> getReflection() {
        return Result.class;
    }

}
