package org.papaja.adminfly.module.psy.tests.MMPI.handler;

import org.papaja.adminfly.module.psy.commons.XYValue;
import org.papaja.adminfly.module.psy.commons.function.Caster;
import org.papaja.adminfly.module.psy.commons.function.Value;
import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.MMPI.Bounds;
import org.papaja.adminfly.module.psy.tests.MMPI.BoundsFactory;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.MMPI.converter.PointsTRateConverter;
import org.papaja.adminfly.module.psy.tests.MMPI.converter.PointsTRateQ71Converter;
import org.papaja.adminfly.module.psy.tests.MMPI.jfreechart.JFreeChartService;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.context.Context;
import org.papaja.adminfly.module.psy.tests.handler.Handler;
import org.papaja.function.Converter;

import java.util.*;

import static org.papaja.adminfly.module.psy.tests.MMPI.Scale.*;

public class MMPIHandler implements Handler<MMPIHandlerResult, Context> {

    private static final Scale[][] MMPI_SCALES = new Scale[][]{
            {SCALE_L, SCALE_F, SCALE_K},
            {SCALE_1, SCALE_2, SCALE_3, SCALE_4, SCALE_5_F, SCALE_5_M, SCALE_6, SCALE_7, SCALE_8, SCALE_9, SCALE_0},
    };
    private static final Scale[][] MMPI_MINI_SCALES = new Scale[][]{
            {SCALE_L, SCALE_F, SCALE_K},
            {SCALE_1, SCALE_2, SCALE_3, SCALE_4, SCALE_6, SCALE_7, SCALE_8, SCALE_9},
    };
    private Context context;

    public MMPIHandler(Context context) {
        this.context = context;
    }

    @Override
    public Value<MMPIHandlerResult> handle(Value value) {
        Map<Scale, Integer>                               values       = Caster.cast(value.get(), Map.class);
        MMPIHandlerResult                                 result       = new MMPIHandlerResult();
        Converter<Map<Scale, Integer>, Map<Scale, Float>> converter    = createConverter();
        Map<Scale, Float>                                 rates        = converter.convert(values);
        JFreeChartService                                 chartService = new JFreeChartService(getContext().getTest().getName(), "Scales", "T-Rates", splitRates(rates));

        Bounds bounds = BoundsFactory.createBounds(getContext().getTest());

        chartService.setMarker(new XYValue<>(bounds.getBoundA(), bounds.getBoundB()));

        result.setChart(chartService.build());
//        result.setWelsh(new WelshCode().getCode());

        return new Value<>(result);
    }

    @Override
    public Context getContext() {
        return context;
    }

    private List<Map<String, Double>> splitRates(Map<Scale, Float> rates) {

        List<Map<String, Double>> split = new ArrayList<>();

        Scale[][] scaleSplit = getContext().getTest().equals(Test.MMPI_71) ? MMPI_MINI_SCALES : MMPI_SCALES;

        for (Scale[] scales : scaleSplit) {
            split.add(new LinkedHashMap<>() {{
                for (Scale scale : scales) {
                    if (scale.equals(SCALE_5_F) || scale.equals(SCALE_5_M)) {
                        continue;
//                        if (getContext().getGender().equals(Gender.F)) {
//                            scale = SCALE_5_F;
//                        } else {
//                            scale = SCALE_5_M;
//                        }
                    }

                    put(scale.getPrintableName(), rates.get(scale).doubleValue());
                }
            }});
        }

        System.out.println(split);

        return split;
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

}
