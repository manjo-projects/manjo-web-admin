package org.papaja.kv.reposirory;

import org.papaja.kv.entity.KeyValue;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class KVRepository extends AbstractRepository<KeyValue> {

    @Override
    public Class<KeyValue> getReflection() {
        return KeyValue.class;
    }

}
