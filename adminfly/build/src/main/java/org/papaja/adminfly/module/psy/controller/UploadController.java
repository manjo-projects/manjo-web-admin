package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.dto.UploadFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/psy/upload")
public class UploadController extends AbstractPsyController {

    @PostMapping
    public RedirectView receive(@Valid UploadFile file) {
        System.out.println(file);
        System.out.println(file.getFile().getContentType());

        return new RedirectView("/psy/patients");
    }

}
