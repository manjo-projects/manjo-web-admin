package org.papaja.adminfly.module.buildin.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

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
    public static class ToBuildIn extends AbstractController {
        @RequestMapping
        public ModelAndView home(RedirectAttributes attributes) {
            ModelAndView mav = new ModelAndView("redirect:/build-in/");

            attributes.addFlashAttribute("message",
                    messages.getSuccessMessage("record.removed.id", "path", new Random().nextInt()));

            return mav;
        }
    }

}
