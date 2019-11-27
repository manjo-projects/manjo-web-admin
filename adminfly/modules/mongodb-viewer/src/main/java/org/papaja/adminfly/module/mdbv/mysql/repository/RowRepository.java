package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.commons.mvc.repository.AbstractRepository;
import org.papaja.adminfly.module.mdbv.mysql.entity.Row;
import org.springframework.stereotype.Repository;

@Repository
public class RowRepository extends AbstractRepository<Row> {

    @Override
    public Class<Row> getReflection() {
        return Row.class;
    }
}
