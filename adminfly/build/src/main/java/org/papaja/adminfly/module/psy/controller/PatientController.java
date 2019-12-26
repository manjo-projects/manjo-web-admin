package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.module.psy.dbl.dto.PatientDto;
import org.papaja.adminfly.module.psy.dbl.dto.SessionDto;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.mapper.PatientMapper;
import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.geo.Locale;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import static java.lang.String.format;
import static java.util.Objects.isNull;

@Controller
@RequestMapping("/patients")
public class PatientController extends AbstractPsyController {

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/activate/{id:[0-9]+}"})
    public ModelAndView startTest(
            @PathVariable(value = "id") Integer id,
            @RequestParam(value = "test", required = false) String test,
            RedirectAttributes attributes
    ) {
        context.setPatient(patients.getOne(id));

        attributes.addFlashAttribute("message",
                messages.getSuccessMessage("text.patientActivated", id));

        return newRedirect(isNull(test) ? "tests" : test);
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping
    public ModelAndView patients() {
        ModelAndView mav = newView("patients/index");

        mav.addObject("items", patients.getAll());

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/profile/{id:[0-9]+}"})
    public ModelAndView profile(
            @PathVariable(value = "id") Integer id
    ) {
        ModelAndView mav     = newView("patients/profile");
        Patient      patient = patients.getOne(id);

        mav.addObject("profile", patient);
        mav.addObject("tests", Test.values());
        mav.addObject("sessions", sessions.getSessions(patient));
        mav.addObject("url", ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
        mav.addObject("locale", Locale.UK_UA);

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @PostMapping(value = {"/profile/{id:[0-9]+}"})
    public ModelAndView createSession(
            @PathVariable(value = "id") Integer id,
            @Valid SessionDto dto, BindingResult result,
            RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect(format("patients/profile/%d", id));

        if (result.hasErrors()) {
            mav = profile(id);
            mav.addObject("result", result);
        } else {
            sessions.newSession(patients.getOne(id), dto.getTest());

            attributes.addFlashAttribute("message",
                    messages.getSuccessMessage("record.saved",
                            getMessage("label.session")));
        }

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping(value = {"/edit/{id:[0-9]+}", "/patients/create"})
    public ModelAndView editPatient(
            @PathVariable(value = "id", required = false) Integer id
    ) {
        ModelAndView mav = newView("patients/form");

        mav.addObject("genders", Gender.values());
        mav.addObject("patient", patients.getOne(id));

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @PostMapping(value = {"/edit/{id:[0-9]+}", "/patients/create"})
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

}
