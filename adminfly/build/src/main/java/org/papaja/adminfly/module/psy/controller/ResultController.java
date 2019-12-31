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
import org.jfree.data.xy.XYSeries;
import org.papaja.adminfly.commons.dao.service.BlogFileService;
import org.papaja.adminfly.module.psy.dbl.entity.Document;
import org.papaja.adminfly.module.psy.tests.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.sql.Timestamp;

@Controller("psyResultController")
@RequestMapping("/results")
public class ResultController extends AbstractPsyController {

    @Autowired
    private BlogFileService files;

    @PreAuthorize("hasAnyAuthority('READ')")
    @ResponseBody
    @GetMapping(value = "/chart", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] chart() throws IOException {
//        DefaultCategoryDataset

        XYSeries series = new XYSeries("XYSeries");

        series.add(3.4f, 3.5f);
        series.add(2.4f, 1.5f);
        series.add(4.4f, 6.5f);
        series.add(2.4f, 1.5f);
        series.add(4.4f, 6.5f);
        series.add(7.4f, 2.5f);

//        XYSeriesCollection dataset = new XYSeriesCollection();
//        dataset.addSeries(series);

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
        ModelAndView mav = newView("index");

        mav.addObject("results", results.getAll());

        return mav;
    }

    @GetMapping("/{id:\\d+}")
    @PreAuthorize("hasAnyAuthority('READ')")
    public ModelAndView result(
            @PathVariable("id") Integer id
    ) {
        ModelAndView mav = newView("result");

        System.out.println(results.getOne(id));
        mav.addObject("result", results.getOne(id));

        return mav;
    }

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView mav = newView("result");

        Document document = new Document();

        document.setAlgorithm("none");
        document.setCompressed(false);
        document.setCreated(new Timestamp(123123123L));
        document.setUpdated(new Timestamp(1223123123L));
        document.setData(new byte[]{
                (byte) 0x7b, (byte) 0x20, (byte) 0x7b
        });
        document.setName("test");
        document.setMime("unknown");

        files.merge(document);

        return mav;
    }

}
