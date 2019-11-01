package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/psy/mmpi2")
public class Mmpi2Controller extends AbstractController {

    @GetMapping(value = {"/test"})
    public ModelAndView test() {
        return newView("test");
    }

}
