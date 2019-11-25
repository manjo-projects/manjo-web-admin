package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.service.BlogFileService;
import org.papaja.adminfly.module.psy.dbl.entity.Document;
import org.papaja.adminfly.module.psy.dbl.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;

@Controller("psyResultController")
@RequestMapping("/psy/results")
public class ResultController extends AbstractPsyController {

    @Autowired
    private ResultService results;

    @Autowired
    private BlogFileService files;

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
