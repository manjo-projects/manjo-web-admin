package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.DataHolder;
import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.papaja.adminfly.module.psy.database.service.PatientService;
import org.papaja.adminfly.module.psy.database.service.ResultService;
import org.papaja.adminfly.module.psy.database.service.SessionService;
import org.papaja.adminfly.module.psy.tests.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
abstract public class AbstractPsyController extends AbstractController {

    @Autowired
    protected SessionContext context;

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
