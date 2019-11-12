package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.module.psy.dbl.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("psyResultsController")
@RequestMapping("/psy/results")
public class ResultController extends AbstractPsyController {

    @Autowired
    private ResultService results;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('READ')")
    public ModelAndView index() {

        System.out.println(results.getOne(1));


        return newView("index");
    }

}
