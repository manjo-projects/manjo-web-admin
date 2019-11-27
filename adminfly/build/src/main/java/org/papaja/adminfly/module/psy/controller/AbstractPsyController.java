package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.commons.mvc.controller.AbstractController;
import org.papaja.adminfly.commons.mvc.module.ThemeData;
import org.papaja.adminfly.module.psy.commons.holder.TestContextHolder;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
abstract public class AbstractPsyController extends AbstractController {

    @Autowired
    protected TestContextHolder.Context context;

    @Autowired
    protected PatientService patients;

    @Autowired
    private ThemeData data;

    @ModelAttribute
    public void sharedData(Model model) {
        Patient patient = context.getPatient();

        model.addAttribute("patient", patient);
    }

}
