package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.module.psy.dbl.dto.PatientDto;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.mapper.PatientMapper;
import org.papaja.adminfly.module.psy.dbl.service.PatientService;
import org.papaja.adminfly.module.psy.tests.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@SuppressWarnings({"unused"})
@Controller("psyIndexController")
@RequestMapping(value = "/psy")
public class IndexController extends AbstractPsyController {

    @ModelAttribute
    public void model(Model model) {
        model.addAttribute("patient", patient);
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/"})
    public ModelAndView index() {
        return newView("index");
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/patients"})
    public ModelAndView patients() {
        ModelAndView mav = newView("patients/index");

        mav.addObject("items", patients.getAll());

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/patients/view/{id:[0-9]+}"})
    public ModelAndView view(
            @PathVariable(value = "id") Integer id
    ) {
        ModelAndView mav = newView("patients/view");

        mav.addObject("item", patients.getOne(id));

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/patients/edit/{id:[0-9]+}", "/patients/create"})
    public ModelAndView editPatient(
            @PathVariable(value = "id", required = false) Integer id
    ) {
        ModelAndView mav = newView("patients/form");

        mav.addObject("patient", patients.getOne(id));

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @PostMapping(value = {"/patients/edit/{id:[0-9]+}", "/patients/create"})
    public ModelAndView savePatient(
            @PathVariable(value = "id", required = false) Integer id,
            @Valid PatientDto dto, BindingResult result,
            RedirectAttributes attributes
    ) {
        ModelAndView mav     = newView("patients/form");
        Patient      patient = patients.getOne(id);

        if (result.hasErrors()) {
            mav.addObject("result", result);
        } else {
            new PatientMapper().map(dto, patient);
            patients.merge(patient);
            mav = newRedirect("patients");
            attributes.addFlashAttribute("message",
                    messages.getSuccessMessage("record.saved",
                            getMessage("label.patients")));
        }

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/results/index"})
    public ModelAndView results() {
        return newView("results");
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/tests"})
    public ModelAndView tests() {
        ModelAndView mav = newView("tests/index");

        mav.addObject("items", Test.values());

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/patients/activate/{id:[0-9]+}"})
    public ModelAndView startTest(
            @PathVariable(value = "id") Integer id,
            @RequestParam(value = "test") String test,
            RedirectAttributes attributes
    ) {
        patient.set(id);

        attributes.addFlashAttribute("message", "Activated!");

        return newRedirect(test);
    }

}
