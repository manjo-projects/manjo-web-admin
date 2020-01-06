package org.papaja.adminfly.module.psy.controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.Layer;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.papaja.adminfly.module.psy.commons.function.Preparer;
import org.papaja.adminfly.module.psy.commons.function.Value;
import org.papaja.adminfly.module.psy.database.entity.results.Result;
import org.papaja.adminfly.module.psy.database.preparer.PreparerFactory;
import org.papaja.adminfly.module.psy.tests.Context;
import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.HandlerFactory;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.builder.context.TestContextBuilder;
import org.papaja.adminfly.module.psy.tests.Handler;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static java.lang.String.format;

@Controller
@RequestMapping("/results")
public class ResultController extends AbstractPsyController {

    @PreAuthorize("hasAnyAuthority('READ')")
    @ResponseBody
    @GetMapping(value = "/chart", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] chart() throws IOException {
//        DefaultCategoryDataset


        DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();

        dataset.add(45, 0, "LFK", "L");
        dataset.add(70, 0, "LFK", "F");
        dataset.add(31, 0, "LFK", "K");

        dataset.add(34, 0, "SCALES", "SCALE_1");
        dataset.add(22, 0, "SCALES", "SCALE_2");
        dataset.add(60, 0, "SCALES", "SCALE_3");
        dataset.add(33, 0, "SCALES", "SCALE_4");
        dataset.add(45, 0, "SCALES", "SCALE_5");
        dataset.add(99, 0, "SCALES", "SCALE_6");
        dataset.add(33.4, 0, "SCALES", "SCALE_X");

        JFreeChart chart = ChartFactory.createLineChart(Test.MMPI_71.getName(), "Scales", "T-Rates",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                true
        );

        chart.getCategoryPlot().getRangeAxis().setRange(0, 120);

        CategoryPlot plot = chart.getCategoryPlot();

        LineAndShapeRenderer renderer = new LineAndShapeRenderer();

        chart.getCategoryPlot().setRenderer(renderer);

        renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6));
        renderer.setSeriesShape(1, new Ellipse2D.Double(-3, -3, 6, 6));

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        IntervalMarker target = new IntervalMarker(31.0, 77.5, Color.decode("#00bd00"));
        target.setAlpha(0.15f);
        plot.addRangeMarker(target, Layer.BACKGROUND);

        renderer.setSeriesPaint(0, Color.decode("#ab211a"));
        renderer.setSeriesPaint(1, Color.decode("#1a80ed"));

        renderer.setSeriesStroke(0, new BasicStroke(3.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));

        chart.getCategoryPlot().setBackgroundPaint(Color.WHITE);

        chart.setBackgroundPaint(Color.WHITE);

        chart.setAntiAlias(true);


        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        ChartUtils.writeChartAsPNG(stream, chart, 1000, 600);

        return stream.toByteArray();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('READ')")
    public ModelAndView index() {
        ModelAndView mav = newView("results/index");

        mav.addObject("results", results.getAll());

        return mav;
    }

    @GetMapping("/{id:\\d+}")
    @PreAuthorize("hasAnyAuthority('READ')")
    public ModelAndView result(
            @PathVariable("id") Integer id
    ) {
        Result       result = results.getOne(id);
        ModelAndView mav    = newView(format("results/%s/index", result.getTest()));
        Gender       gender = result.getPatient().getGender();
        Test         test   = result.getTest();

        System.out.println(result.getClass().getName());

        Context context = new TestContextBuilder()
                .with(gender).with(test)
                .build();

        Preparer preparer = PreparerFactory.createPreparer(test, gender);

        Value value = preparer.prepare(result);

        System.out.println(value.get());

        Handler handler = HandlerFactory.createHandler(context);

        System.out.println(handler.getClass().getName());

        handler.handle(value);

/*        System.out.println(points);

        points.forEach((scale, integer) -> {
            points.put(scale, integer + 10);
        });

        Caster.cast("", String.class);

        Map<Scale, Float> rates = new PointsTRateConverterFactory()
                .createConverter(new TestContextBuilder().with(result.getTest()).build())
                .getTRates(new RawPointsPayload(new Pair<>(points, result.getPatient().getGender())));

        System.out.println(rates);*/

        mav.addObject("result", result);

        return mav;
    }

}
