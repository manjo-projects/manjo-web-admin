package org.papaja.adminfly.module.psy.tests.MMPI.jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.Layer;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.papaja.adminfly.module.psy.commons.XYValue;
import org.papaja.adminfly.module.psy.tests.Builder;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.awt.Color.decode;
import static java.lang.String.format;
import static org.jfree.chart.ChartUtils.writeChartAsPNG;

@SuppressWarnings({"unused", "Duplicates"})
public class JFreeChartService implements Builder<byte[]> {

    private static final Ellipse2D.Double CIRCLE                  = new Ellipse2D.Double(-3, -3, 6, 6);
    private static final BasicStroke      BASIC_STROKE            = new BasicStroke(3.0f);
    private static final IntervalMarker   DEFAULT_INTERVAL_MARKER = new IntervalMarker(0, 0, Color.decode("#00bd00"));
    private static final XYValue<Integer> DEFAULT_SIZE            = new XYValue<>(1000, 600);


    private JFreeChart           chart;
    private LineAndShapeRenderer renderer;
    private XYValue<Integer>     size   = DEFAULT_SIZE;
    private IntervalMarker       marker = DEFAULT_INTERVAL_MARKER;

    public JFreeChartService(String title, String xTitle, String yTitle, List<Map<Double, String>> data) {
        byte[]                            bytes    = new byte[0];
        DefaultStatisticalCategoryDataset dataset  = new DefaultStatisticalCategoryDataset();
        int                               counter  = 0;
        int                               size     = data.size();
        LineAndShapeRenderer              renderer = new LineAndShapeRenderer();

        for (int i = 0; i < size; i++) {
            renderer.setSeriesShape(i, CIRCLE);
            renderer.setSeriesPaint(i, i % 2 == 0 ? Colors.RED.getColor() : Colors.BLUE.getColor());
            renderer.setSeriesStroke(i, BASIC_STROKE);
        }

        for (Map<Double, String> datum : data) {
            String row = format("R%d", counter++);
            datum.forEach((value, name) -> dataset.add(value.doubleValue(), 0D, row, name));
        }

        chart = ChartFactory.createLineChart(
                title, xTitle, yTitle, dataset, PlotOrientation.VERTICAL, false, false, true);
    }

    @Override
    public byte[] build() {
        byte[]                bytes  = new byte[0];
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        CategoryPlot          plot   = chart.getCategoryPlot();

        plot.getRangeAxis().setRange(0, 120);
        plot.setRenderer(renderer);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.addRangeMarker(marker, Layer.BACKGROUND);

        marker.setAlpha(0.15f);

        chart.getCategoryPlot().setBackgroundPaint(Colors.WHITE.getColor());
        chart.setBackgroundPaint(Colors.WHITE.getColor());
        chart.setAntiAlias(true);

        try {
            writeChartAsPNG(stream, chart, size.getX(), size.getY());
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return stream.toByteArray();
    }

    enum Colors {

        RED(decode("#ab211a")),
        BLUE(decode("#1a80ed")),
        BLACK(Color.BLACK),
        WHITE(Color.WHITE),
        GREEN(decode("#00bd00"));

        private Color color;

        Colors(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

    }

}
