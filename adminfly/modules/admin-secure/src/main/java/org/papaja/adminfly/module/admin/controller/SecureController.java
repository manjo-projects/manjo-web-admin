package org.papaja.adminfly.module.admin.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secure")
@Secured("ROLE_ADMIN")
public class SecureController extends AbstractController {

    @GetMapping("")
    public ModelAndView redirect() {
        return newRedirect("users");
    }

}
