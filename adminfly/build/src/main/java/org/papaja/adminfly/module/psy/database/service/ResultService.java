package org.papaja.adminfly.module.psy.database.service;

import org.papaja.adminfly.commons.dao.service.AbstractService;
import org.papaja.adminfly.module.psy.database.entity.results.Result;
import org.papaja.adminfly.module.psy.database.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.papaja.adminfly.commons.utils.Randomizer.getRandomHexadecimal;

@Service
public class ResultService extends AbstractService<Result, ResultRepository> {

    private final ResultRepository repository;

    @Autowired
    public ResultService(ResultRepository repository) {
        this.repository = repository;
    }

    public void proceed(Result result) {
        result.setUniqueId(getRandomHexadecimal(24).toUpperCase());

        merge(result);
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
