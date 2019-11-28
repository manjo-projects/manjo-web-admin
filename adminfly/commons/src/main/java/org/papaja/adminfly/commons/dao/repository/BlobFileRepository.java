package org.papaja.adminfly.commons.dao.repository;

import org.papaja.adminfly.commons.dao.entity.BlobFile;
import org.springframework.stereotype.Repository;

@Repository
public class BlobFileRepository extends AbstractRepository<BlobFile> {

    @Override
    public Class<BlobFile> getReflection() {
        return BlobFile.class;
    }
}
