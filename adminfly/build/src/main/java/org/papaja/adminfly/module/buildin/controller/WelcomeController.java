package org.papaja.adminfly.module.buildin.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@SuppressWarnings({"unused"})
public class WelcomeController extends AbstractController {

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home")
    public void home(Authentication authentication, Model model) {
        model.addAttribute("authentication", authentication);
    }

}
