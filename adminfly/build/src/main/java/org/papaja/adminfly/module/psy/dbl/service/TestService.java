package org.papaja.adminfly.module.psy.dbl.service;

import org.papaja.adminfly.commons.service.AbstractService;
import org.papaja.adminfly.module.psy.dbl.entity.Test;
import org.papaja.adminfly.module.psy.dbl.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService extends AbstractService<Test, TestRepository> {

    private TestRepository repository;

    @Autowired
    public TestService(TestRepository repository) {
        this.repository = repository;
    }

    @Override
    public TestRepository getRepository() {
        return repository;
    }

    @Override
    public Test get() {
        return new Test();
    }

}
