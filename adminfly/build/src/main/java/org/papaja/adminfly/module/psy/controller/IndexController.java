package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings({"unused"})
@Controller("psyIndexController")
@RequestMapping(value = "/psy")
public class IndexController extends AbstractController {

    @GetMapping(value = {"/"})
    public ModelAndView index() {
        return newView("index");
    }

    @GetMapping(value = {"/patients"})
    public ModelAndView patients() {
        return newView("patients/index");
    }

    @GetMapping(value = {"/patients/edit/{id:[0-9]+}", "/patients/create"})
    public ModelAndView editPatient() {
        return newView("patients/form");
    }

    @GetMapping(value = {"/results"})
    public ModelAndView results() {
        return newView("results");
    }

    @GetMapping(value = {"/tests"})
    public ModelAndView tests() {
        return newView("tests");
    }

}
