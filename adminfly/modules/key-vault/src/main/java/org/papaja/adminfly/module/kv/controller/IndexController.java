package org.papaja.adminfly.module.kv.controller;

import org.papaja.adminfly.module.kv.dto.KeyValueDto;
import org.papaja.adminfly.module.kv.service.KVService;
import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller("kvIndexController")
@RequestMapping(value = "/kv", produces = MediaType.TEXT_PLAIN_VALUE)
public class IndexController extends AbstractController {

    private final KVService kvs;

    @Autowired
    public IndexController(KVService kvs) {
        this.kvs = kvs;
    }

    @GetMapping(value = {"/get/{key:\\w_+}"})
    @ResponseBody
    public String get(@PathVariable(value = "key") String key) {
        ModelAndView mav = newView("index");

//        mav.addObject("entity", kvs.getOne());

        return key;
    }

    @GetMapping(value = {"/", "/index", "/edit/{id:[0-9]+}"})
    public ModelAndView index(@PathVariable(value = "id", required = false) Integer id) {
        ModelAndView mav = newView("index");

        mav.addObject("entity", kvs.getOne(id));
        mav.addObject("kvs", kvs.getAll());

        return mav;
    }

    @PostMapping(value = {"/save", "/save/{id:[0-9]+}"})
    public ModelAndView save(
        @Valid KeyValueDto dto, BindingResult result, RedirectAttributes attributes,
        @PathVariable(value = "id", required = false) Integer id
    ) {
        ModelAndView mav = newView("index");

        mav.addObject("kvs", kvs.getAll());

        if (result.hasErrors()) {
            mav.addObject("result", result);
            mav.addObject("entity", dto);
        } else {
            attributes.addFlashAttribute("message",
                messages.getSuccessMessage("record.saved", dto.getKey()));
            kvs.save(dto, kvs.getOne(id));
            mav = newRedirect("index");
        }

        return mav;
    }

}
