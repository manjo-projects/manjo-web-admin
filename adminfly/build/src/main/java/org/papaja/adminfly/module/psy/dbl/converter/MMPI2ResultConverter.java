package org.papaja.adminfly.module.psy.dbl.converter;

import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.results.MMPI2Result;
import org.papaja.adminfly.module.psy.tests.mmpi2.Points;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Scale;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Sex;
import org.papaja.function.Converter;
import org.papaja.tuple.Triplet;

public class MMPI2ResultConverter<Result extends MMPI2Result>
        implements Converter<Triplet<Result, Points, Patient>, Result> {

    @Override
    public Result convert(Triplet<Result, Points, Patient> data) {
        Points  points  = data.getB();
        Patient patient = data.getC();
        Result  result  = data.getA();

        result.setPatient(patient);

        result.setScaleL(points.points(Scale.SCALE_L));
        result.setScaleF(points.points(Scale.SCALE_F));
        result.setScaleK(points.points(Scale.SCALE_K));
        result.setScale0(points.points(Scale.SCALE_0));
        result.setScale1(points.points(Scale.SCALE_1));
        result.setScale2(points.points(Scale.SCALE_2));
        result.setScale3(points.points(Scale.SCALE_3));
        result.setScale4(points.points(Scale.SCALE_4));
        result.setScale6(points.points(Scale.SCALE_6));
        result.setScale7(points.points(Scale.SCALE_7));
        result.setScale8(points.points(Scale.SCALE_8));
        result.setScale9(points.points(Scale.SCALE_9));

        result.setScale5(
                points.points(patient.getSex().equals(Sex.F) ? Scale.SCALE_5_F : Scale.SCALE_5_M)
        );

        return result;
    }

}
