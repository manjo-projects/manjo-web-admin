package org.papaja.adminfly.module.psy.controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.papaja.adminfly.commons.dao.service.BlogFileService;
import org.papaja.adminfly.module.psy.dbl.entity.Document;
import org.papaja.adminfly.module.psy.dbl.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;

@Controller("psyResultController")
@RequestMapping("/psy/results")
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
        series.add(7.4f, 2.5f);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart("test1", "test2", "test3",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        ChartUtils.writeChartAsPNG(stream, chart, 800, 600);

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
        document.setData(new byte[] {
            (byte)0x7b, (byte)0x20, (byte)0x7b
        });
        document.setName("test");
        document.setMime("unknown");

        files.merge(document);

        return mav;
    }

}
