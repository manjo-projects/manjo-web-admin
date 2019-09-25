package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.module.mdbv.mysql.entity.Row;
import org.papaja.adminfly.core.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RowRepository extends AbstractRepository<Row> {

    @Override
    public Class<Row> getReflection() {
        return Row.class;
    }
}
