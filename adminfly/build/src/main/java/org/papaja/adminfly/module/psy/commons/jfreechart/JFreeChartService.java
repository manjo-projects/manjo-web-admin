package org.papaja.adminfly.module.psy.commons.jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.Layer;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

@SuppressWarnings({"unused", "Duplicates"})
public class JFreeChartService {

    private static final Ellipse2D.Double CIRCLE = new Ellipse2D.Double(-3, -3, 6, 6);

    public static byte[] create(String title, String xTitle, String yTitle, List<Map<Double, String>> data) {
        byte[]                            bytes   = new byte[0];
        DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();
        int                               counter = 0;

        for (Map<Double, String> datum : data) {
            String row = format("R%d", counter++);
            datum.forEach((value, name) -> dataset.add(value.doubleValue(), 0D, row, name));
        }

        JFreeChart chart = ChartFactory.createLineChart(
                title, xTitle, yTitle, dataset, PlotOrientation.VERTICAL, false, false, true);

        chart.getCategoryPlot().getRangeAxis().setRange(0, 120);

        CategoryPlot         plot     = chart.getCategoryPlot();
        IntervalMarker       target   = new IntervalMarker(31.0, 77.5, Color.decode("#00bd00"));
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();

        chart.getCategoryPlot().setRenderer(renderer);

        renderer.setSeriesShape(0, CIRCLE);
        renderer.setSeriesShape(1, CIRCLE);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        plot.addRangeMarker(target, Layer.BACKGROUND);


        target.setAlpha(0.15f);

        renderer.setSeriesPaint(0, Color.decode("#ab211a"));
        renderer.setSeriesPaint(1, Color.decode("#1a80ed"));

        renderer.setSeriesStroke(0, new BasicStroke(3.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));

        chart.getCategoryPlot().setBackgroundPaint(Color.WHITE);

        chart.setBackgroundPaint(Color.WHITE);

        chart.setAntiAlias(true);


        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        try {
            ChartUtils.writeChartAsPNG(stream, chart, 1000, 600);
            bytes = stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

}
