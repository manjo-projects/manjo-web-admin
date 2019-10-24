package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.controller.AbstractController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("psyIndexController")
@RequestMapping(value = "/psy-tests")
public class IndexController extends AbstractController {

    @GetMapping(value = {"/"})
    public String index() {
        return "psy-tests/index";
    }

}
