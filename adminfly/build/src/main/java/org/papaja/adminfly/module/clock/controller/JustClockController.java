package org.papaja.adminfly.module.clock.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Optional.ofNullable;
import static org.papaja.adminfly.commons.DataHolder.HOLDER;

@Controller
@RequestMapping("/shared")
public class JustClockController extends AbstractController {

    private static final String LOGO_TEXT = "\uD83D\uDD52 Just Clock";

    {
        setPrefix("clock");
    }

    @RequestMapping({"/clock", "/clock/{theme:[\\w\\d_]+}"})
    public ModelAndView index(
            @PathVariable(name = "theme", required = false) String theme
    ) {
        String       name = ofNullable(theme).orElse("default");
        ModelAndView mav  = newView("index/index");

        // manually set module name
        HOLDER.set("main.name", LOGO_TEXT);
        HOLDER.setKey("CLOCK");

        mav.addObject("name", name);

        return mav;
    }

}