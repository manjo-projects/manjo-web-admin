package org.papaja.adminfly.commons.mvc.service;

import org.papaja.adminfly.commons.mvc.entity.BlobFile;
import org.papaja.adminfly.commons.mvc.repository.BlobFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class BlogFileService extends AbstractService<BlobFile, BlobFileRepository> {

    private final BlobFileRepository repository;

    @Autowired
    public BlogFileService(BlobFileRepository repository) {
        this.repository = repository;
    }

    @Override
    public BlobFileRepository getRepository() {
        return repository;
    }

    @Override
    public BlobFile get() {
        throw new UnsupportedOperationException(
                format("Unable instantiate abstract '%s' directly", BlobFile.class.getName())
        );
    }

}
