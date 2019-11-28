package org.papaja.adminfly.module.psy.dbl.service;

import org.papaja.adminfly.commons.dao.service.AbstractService;
import org.papaja.adminfly.module.psy.dbl.entity.results.Result;
import org.papaja.adminfly.module.psy.dbl.repository.ResultRepository;
import org.papaja.adminfly.module.psy.tests.mmpi2.Points;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService extends AbstractService<Result, ResultRepository> {

    private final ResultRepository repository;

    @Autowired
    public ResultService(ResultRepository repository) {
        this.repository = repository;
    }

    public void save(Points points) {

    }

    @Override
    public ResultRepository getRepository() {
        return repository;
    }

    @Override
    public Result get() {
        throw new UnsupportedOperationException("Unable to instantiate abstract class");
    }

}
