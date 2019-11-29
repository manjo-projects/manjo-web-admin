package org.papaja.adminfly.module.buildin.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@SuppressWarnings({"unused"})
@RequestMapping("/build-in")
public class BuildInController extends AbstractController {

    {
        setPrefix("");
    }

    @RequestMapping
    public String home(HttpServletRequest request) {
        return "redirect:/build-in/home";
    }

    @RequestMapping(value = "/home")
    public ModelAndView home(Authentication authentication) {
        ModelAndView mav = newView("home");

        mav.addObject("authentication", authentication);

        return mav;
    }

    @Controller
    @RequestMapping("/")
    public static class ToBuildIn {
        @RequestMapping
        public String home() {
            return "redirect:/build-in/";
        }
    }

}
