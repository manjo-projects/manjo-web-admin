package org.papaja.adminfly.module.admin.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.papaja.adminfly.commons.support.SystemInformation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Runtime.getRuntime;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/system")
public class SystemController extends AbstractController {

    @RequestMapping("")
    public ModelAndView redirect() {
        return newRedirect("status");
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/status")
    public ModelAndView status() {
        ModelAndView mav = newView("status");

        mav.addObject("info", new SystemInformation());

        return mav;
    }

    @RequestMapping("/gc")
    @PreAuthorize("hasAuthority('SYSTEM')")
    public ModelAndView gc() {
        getRuntime().gc();

        return newRedirect("status");
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/setting")
    public void setting(HttpServletRequest request, Model model) {
        model.addAttribute("uri", request.getRequestURI());
    }

}
