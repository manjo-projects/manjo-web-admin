package org.papaja.adminfly.module.psy.dbl.service;

import org.papaja.adminfly.commons.dao.service.AbstractService;
import org.papaja.adminfly.module.psy.dbl.converter.MMPIResultConverter;
import org.papaja.adminfly.module.psy.dbl.entity.Session;
import org.papaja.adminfly.module.psy.dbl.entity.results.Result;
import org.papaja.adminfly.module.psy.dbl.repository.ResultRepository;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.tuple.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResultService extends AbstractService<Result, ResultRepository> {

    private final ResultRepository    repository;
    private final MMPIResultConverter converter;

    @Autowired
    public ResultService(ResultRepository repository) {
        this.repository = repository;
        this.converter = new MMPIResultConverter();
    }

    public void proceed(Map<Scale, Integer> points, Result result, Session session) {
        merge(converter.convert(new Triplet(result, points, session.getPatient())));
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
