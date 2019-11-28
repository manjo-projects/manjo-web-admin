package org.papaja.adminfly.module.psy.dbl.mapper;

import org.papaja.adminfly.commons.dao.mapper.AbstractMapper;
import org.papaja.adminfly.module.psy.dbl.entity.results.MMPI2SobchikResult;
import org.papaja.adminfly.module.psy.tests.mmpi2.Points;

public class MMPI2SobchikMapper extends AbstractMapper<Points, MMPI2SobchikResult> {

    @Override
    public void accept(Points points, MMPI2SobchikResult result) {
        Class<?> reflection = result.getClass();

//        reflection.getMethod()
    }

    @Override
    public MMPI2SobchikResult get() {
        return new MMPI2SobchikResult();
    }
}
