package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.module.psy.database.entity.Session;
import org.papaja.adminfly.module.psy.database.service.SessionService;
import org.papaja.adminfly.module.psy.tests.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static java.lang.String.format;

@SuppressWarnings({"unused"})
@Controller
public class IndexController extends AbstractPsyController {

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping("")
    public ModelAndView index() {
        return newView("index");
    }


    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/tests"})
    public ModelAndView tests() {
        ModelAndView mav = newView("tests/index");

        mav.addObject("items", Test.values());

        return mav;
    }

    @Controller
    @RequestMapping("/shared")
    public static class Shared extends AbstractPsyController {

        @Autowired
        private SessionService sessions;

        @GetMapping("/_/{session}")
        public ModelAndView session(
                @PathVariable("session") String hash
        ) {
            Session      session = sessions.getSession(hash);
            ModelAndView mav     = newRedirect(format("shared/%s", session.getTest().name()));

            if (session.isOld() && session.isActive()) {
                context.setSession(session);
            } else {
                mav = newRedirect("shared/undefined");
            }

            return mav;
        }

        @GetMapping("/undefined")
        public ModelAndView undefined() {
            return newView("shared/undefined");
        }

    }

}
