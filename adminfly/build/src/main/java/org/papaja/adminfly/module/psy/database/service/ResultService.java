package org.papaja.adminfly.module.psy.database.service;

import org.papaja.adminfly.commons.dao.service.AbstractService;
import org.papaja.adminfly.module.psy.database.converter.MMPIToPointsConverter;
import org.papaja.adminfly.module.psy.database.converter.MMPIToResultConverter;
import org.papaja.adminfly.module.psy.database.entity.Session;
import org.papaja.adminfly.module.psy.database.entity.results.Result;
import org.papaja.adminfly.module.psy.database.repository.ResultRepository;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.tuple.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.papaja.adminfly.commons.utils.Randomizer.getRandomHexadecimal;

@Service
public class ResultService extends AbstractService<Result, ResultRepository> {

    private final ResultRepository      repository;
    private final MMPIToResultConverter toResult;
    private final MMPIToPointsConverter toPoints;

    @Autowired
    public ResultService(ResultRepository repository) {
        this.repository = repository;
        this.toResult = new MMPIToResultConverter();
        this.toPoints = new MMPIToPointsConverter();
    }

    public void proceed(Map<Scale, Integer> points, Result result, Session session) {
        toResult.convert(new Triplet(result, points, session.getPatient()));

        result.setUniqueId(getRandomHexadecimal(24));

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
