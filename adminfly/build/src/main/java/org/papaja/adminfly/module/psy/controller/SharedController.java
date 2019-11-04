package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/shared/psy")
public class SharedController extends AbstractController {

    @GetMapping(value = {"/mmpi-2"})
    public ModelAndView index() {
        return new ModelAndView("/psy/shared/index");
    }

}
