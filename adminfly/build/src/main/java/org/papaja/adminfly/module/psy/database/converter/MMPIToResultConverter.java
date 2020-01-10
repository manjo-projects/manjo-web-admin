package org.papaja.adminfly.module.psy.database.converter;

import org.papaja.adminfly.module.psy.database.entity.results.MMPI.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.context.PatientDetails;
import org.papaja.function.Converter;
import org.papaja.tuple.Triplet;

import java.util.Map;

public class MMPIToResultConverter<Result extends AbstractMMPIResult>
        implements Converter<Triplet<Result, Map<Scale, Integer>, PatientDetails>, Result> {

    @Override
    public Result convert(Triplet<Result, Map<Scale, Integer>, PatientDetails> data) {
        Map<Scale, Integer> points  = data.getB();
        PatientDetails      patient = data.getC();
        Result              result  = data.getA();

        result.setScaleL(points.get(Scale.SCALE_L));
        result.setScaleF(points.get(Scale.SCALE_F));
        result.setScaleK(points.get(Scale.SCALE_K));
        result.setScale0(points.get(Scale.SCALE_0));
        result.setScale1(points.get(Scale.SCALE_1));
        result.setScale2(points.get(Scale.SCALE_2));
        result.setScale3(points.get(Scale.SCALE_3));
        result.setScale4(points.get(Scale.SCALE_4));
        result.setScale6(points.get(Scale.SCALE_6));
        result.setScale7(points.get(Scale.SCALE_7));
        result.setScale8(points.get(Scale.SCALE_8));
        result.setScale9(points.get(Scale.SCALE_9));

        result.setScale5(
                points.get(patient.getGender().equals(Gender.F) ? Scale.SCALE_5_F : Scale.SCALE_5_M)
        );

        return result;
    }

}
