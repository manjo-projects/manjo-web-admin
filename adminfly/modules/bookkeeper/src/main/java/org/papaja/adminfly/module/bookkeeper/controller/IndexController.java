package org.papaja.adminfly.module.bookkeeper.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("bookKeeperIndexController")
@RequestMapping(value = "/bookkeeper", produces = MediaType.TEXT_PLAIN_VALUE)
public class IndexController extends AbstractController {

    @GetMapping(value = {"/"})
    @ResponseBody
    public String get() {
        return getClass().getName();
    }

}
