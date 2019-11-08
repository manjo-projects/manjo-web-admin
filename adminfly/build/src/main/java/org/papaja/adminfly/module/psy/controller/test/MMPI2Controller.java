package org.papaja.adminfly.module.psy.controller.test;

import org.papaja.adminfly.module.psy.controller.AbstractPsyController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

import static org.papaja.adminfly.module.psy.tests.Test.MMPI2;

@Controller
@RequestMapping("/psy/MMPI2")
public class MMPI2Controller extends AbstractPsyController {

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping
    public ModelAndView start() {
        ModelAndView mav = newView("test");

        if (patient.has()) {

        } else {
            mav = newView("choose-patient")
                    .addObject("items", patients.getAll())
                    .addObject("test", MMPI2);
        }

        return mav;
    }

    @Controller
    @RequestMapping("/shared/psy/MMPI2")
    public static class Shared extends AbstractPsyController {

        { setPrefix("/psy/MMPI2/shared"); }

        @GetMapping
        public ModelAndView test() {
            ModelAndView mav = newView("index");

            if (!patient.has()) {
                mav = new ModelAndView("redirect:/shared/psy/undefined");
            }

            return mav;
        }

    }

}
