package org.papaja.adminfly.module.admin.controller;

import org.papaja.adminfly.core.dto.UserDto;
import org.papaja.adminfly.core.controller.AbstractController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/auth")
public class AuthController extends AbstractController {

    @RequestMapping("/")
    public RedirectView home() {
        return newRedirectView("login");
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/login")
    public String login(UserDto user) {
        return "login/login";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/logout")
    public void logout() { }

}
