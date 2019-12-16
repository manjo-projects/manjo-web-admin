package org.papaja.adminfly.buildin.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@SuppressWarnings({"unused"})
@RequestMapping("/build-in")
public class BuildInController extends AbstractController {

    @RequestMapping
    public String home(HttpServletRequest request) {
        return "redirect:/build-in/home";
    }

    @RequestMapping(value = "/home")
    public ModelAndView home(Authentication authentication, HttpSession session) {
        ModelAndView mav = newView("home");

        mav.addObject("authentication", authentication);

        return mav;
    }

    @Controller
    @RequestMapping
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
