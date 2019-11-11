package org.papaja.adminfly.module.psy.controller.test;

import org.papaja.adminfly.module.psy.controller.AbstractPsyController;
import org.papaja.adminfly.module.psy.tests.mmpi2.model.Answer;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static java.lang.String.format;
import static org.papaja.adminfly.module.psy.tests.Test.MMPI2;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/psy/MMPI2")
public class MMPI2Controller extends AbstractPsyController {

    @Autowired
    @Qualifier("wizardMMPI2")
    private Wizard<Answer> wizard;

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping({"", "/index"})
    public ModelAndView index() {
        ModelAndView mav = newView("test");

        wizard.update();

        if (patient.has()) {
            mav.addObject("prefix", getPrefix());
            mav.addObject("position", wizard.position());
            mav.addObject("total", wizard.size());
        } else {
            mav = newView("choose-patient");
            mav.addObject("items", patients.getAll());
            mav.addObject("test", MMPI2);
        }

        return mav;
    }

    @GetMapping({
            "/{direction:(?:FORWARD)+}/{answer:(?:F|T)+}",
            "/{direction:(?:BACKWARD)+}"
    })
    public ModelAndView submit(
            @PathVariable(value = "direction") Direction direction,
            @PathVariable(value = "answer", required = false) Answer answer
    ) {
        System.out.println(wizard.submit(answer, direction));

        return new ModelAndView(format("redirect:%s", getPrefix()));
    }

    @Controller
    @RequestMapping("/shared/psy/MMPI2")
    public static class Shared extends AbstractPsyController {

        {
            setPrefix("/psy/MMPI2/shared");
        }

        @GetMapping
        public ModelAndView test() {
            ModelAndView mav = newView("index");

            if (!patient.has()) {
                mav = new ModelAndView("redirect:/shared/psy/undefined");
            } else {

            }

            return mav;
        }

    }

}
