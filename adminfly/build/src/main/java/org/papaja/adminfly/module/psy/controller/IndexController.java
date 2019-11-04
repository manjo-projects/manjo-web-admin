package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("psyIndexController")
@RequestMapping(value = "/psy")
public class IndexController extends AbstractController {

    @GetMapping(value = {"/"})
    public ModelAndView index() {
        return newView("index");
    }

}