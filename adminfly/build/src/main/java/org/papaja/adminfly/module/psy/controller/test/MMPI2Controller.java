package org.papaja.adminfly.module.psy.controller.test;

import org.papaja.adminfly.module.psy.controller.AbstractPsyController;
import org.papaja.adminfly.module.psy.tests.Test;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/psy/MMPI2")
public class MMPI2Controller extends AbstractPsyController {

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping
    public ModelAndView start(Principal principal) {
        ModelAndView mav = newRedirect("secured");

        if (principal == null) {
            mav = new ModelAndView("redirect:/shared/psy/MMPI2");
        }

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/secured"})
    public ModelAndView test() {
        ModelAndView mav = newView("test");

        if (patient.has()) {
            //
        } else {
            mav = newView("choose-patient")
                    .addObject("items", patients.getAll())
                    .addObject("test", Test.MMPI2);
        }

        return mav;
    }

    @Controller
    @RequestMapping("/shared/psy/MMPI2")
    public static class Shared extends AbstractPsyController {

        @GetMapping
        public ModelAndView start(Principal principal) {
            ModelAndView mav = newRedirect("shared/test");

            if (principal != null) {
                mav = new ModelAndView("redirect:/psy/MMPI2");
            }

            System.out.println(principal);
            System.out.println(patient.has());

            return mav;
        }

    }

}
