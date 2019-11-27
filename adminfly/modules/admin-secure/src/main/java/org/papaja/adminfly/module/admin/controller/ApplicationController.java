package org.papaja.adminfly.module.admin.controller;

import org.papaja.adminfly.commons.support.SystemInformation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Runtime.getRuntime;

@Controller
@RequestMapping("/secure/application")
public class ApplicationController extends AuthorityController {

    @RequestMapping
    public String redirect() {
        return "redirect:/application/status";
    }

    @RequestMapping("/status")
    public void status(Model model) {
        model.addAttribute("info", new SystemInformation());
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
