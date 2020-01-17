package org.papaja.adminfly.module.psy.tests.MMPI.handler;

import org.papaja.adminfly.module.psy.commons.function.Caster;
import org.papaja.adminfly.module.psy.commons.function.Value;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.MMPI.converter.PointsTRateConverter;
import org.papaja.adminfly.module.psy.tests.MMPI.converter.PointsTRateQ71Converter;
import org.papaja.adminfly.module.psy.tests.MMPI.group.AbstractScaleGroup;
import org.papaja.adminfly.module.psy.tests.MMPI.group.MMPIDefaultScaleGroup;
import org.papaja.adminfly.module.psy.tests.MMPI.group.MMPIQ71ScaleGroup;
import org.papaja.adminfly.module.psy.tests.context.Context;
import org.papaja.adminfly.module.psy.tests.handler.Handler;
import org.papaja.function.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MMPIHandler implements Handler<MMPIHandlerResult, Context> {

    private Context context;

    public MMPIHandler(Context context) {
        this.context = context;
    }

    @Override
    public Value<MMPIHandlerResult> handle(Value value) {
        MMPIHandlerResult                                 result    = new MMPIHandlerResult();
        Converter<Map<Scale, Integer>, Map<Scale, Float>> converter = createConverter();
        AbstractScaleGroup                                groups    = createScaleGroup();
        Map<Scale, Integer>                               values    = Caster.cast(value.get(), Map.class);
        Map<Scale, Float>                                 rates     = converter.convert(values);

        return new Value<>(result);
    }

    @Override
    public Context getContext() {
        return context;
    }
    
    private List<Map<Double, String>> convertForChart(Map<Scale, Float> rates) {
        List<Map<Double, String>> split = new ArrayList<>();

        return split
    }

    private Converter<Map<Scale, Integer>, Map<Scale, Float>> createConverter() {
        switch (getContext().getTest()) {
            case MMPI_71:
                return new PointsTRateQ71Converter();
            case MMPI_377:
            case MMPI_566:
                return new PointsTRateConverter(getContext().getGender());
            default:
                throw new IllegalArgumentException("Unable to create MMPI points-to-rate converter");
        }
    }

    private AbstractScaleGroup createScaleGroup() {
        switch (getContext().getTest()) {
            case MMPI_71:
                return new MMPIQ71ScaleGroup();
            case MMPI_377:
            case MMPI_566:
                return new MMPIDefaultScaleGroup();
            default:
                throw new IllegalArgumentException("Unable to create MMPI scale groups");
        }
    }

}
