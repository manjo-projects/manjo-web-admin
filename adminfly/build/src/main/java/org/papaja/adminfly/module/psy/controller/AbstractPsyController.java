package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.DataHolder;
import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.papaja.adminfly.module.psy.commons.holder.TestContextHolder;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.service.PatientService;
import org.papaja.adminfly.module.psy.dbl.service.ResultService;
import org.papaja.adminfly.module.psy.dbl.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
abstract public class AbstractPsyController extends AbstractController {

    @Autowired
    protected TestContextHolder.Context context;

    @Autowired
    protected DataHolder extra;

    @Autowired
    protected PatientService patients;

    @Autowired
    protected ResultService results;

    @Autowired
    protected SessionService sessions;

    @ModelAttribute
    public void sharedData(Model model) {
        model.addAttribute("patient", context.getPatient());
    }

}
