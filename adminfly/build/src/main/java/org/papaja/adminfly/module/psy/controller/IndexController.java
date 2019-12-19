package org.papaja.adminfly.module.psy.controller;

import org.papaja.adminfly.module.psy.commons.crypto.Crypto;
import org.papaja.adminfly.module.psy.dbl.dto.PatientDto;
import org.papaja.adminfly.module.psy.dbl.dto.SessionDto;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.Session;
import org.papaja.adminfly.module.psy.dbl.mapper.PatientMapper;
import org.papaja.adminfly.module.psy.dbl.service.SessionService;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.geo.Locale;
import org.springframework.beans.factory.annotation.Autowired;
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

@SuppressWarnings({"unused"})
@Controller
public class IndexController extends AbstractPsyController {

    @Autowired
    private SessionService sessions;

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping("/test")
    public ModelAndView test() {
        return new ModelAndView("test");
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping("")
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
    @GetMapping(value = {"/patients/profile/{id:[0-9]+}"})
    public ModelAndView profile(
            @PathVariable(value = "id") Integer id
    ) {
        ModelAndView mav     = newView("patients/profile");
        Patient      patient = patients.getOne(id);

        mav.addObject("profile", patient);
        mav.addObject("tests", Test.values());
        mav.addObject("sessions", sessions.getSessions(patient));
        mav.addObject("encryptor", sessions.getEncryptor());
        mav.addObject("url", ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
        mav.addObject("locale", Locale.UK_UA);

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @PostMapping(value = {"/patients/profile/{id:[0-9]+}"})
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
            @RequestParam(value = "test", required = false) String test,
            RedirectAttributes attributes
    ) {
        context.setPatient(patients.getOne(id));

        attributes.addFlashAttribute("message",
                messages.getSuccessMessage("text.patientActivated", id));

        return newRedirect(isNull(test) ? "tests" : test);
    }

    @Controller
    @RequestMapping("/shared/psy")
    public static class Shared extends AbstractPsyController {

        @Autowired
        private SessionService sessions;

        @GetMapping("/_/{session}")
        public ModelAndView session(
                @PathVariable("session") String hash
        ) {
            Crypto  crypto  = sessions.getEncryptor();
            Session session = sessions.getOne(Integer.valueOf(crypto.decrypt(hash)));
            ModelAndView mav     = newRedirect(session.getTest().toString());

            if (session.isOld() && session.isActive()) {
                context.setSession(session);
                context.setPatient(session.getPatient());
            } else {
                mav = newRedirect("undefined");
            }

            return mav;
        }

        @GetMapping("/undefined")
        public ModelAndView undefined() {
            return new ModelAndView("/psy/shared/undefined");
        }

    }

}
