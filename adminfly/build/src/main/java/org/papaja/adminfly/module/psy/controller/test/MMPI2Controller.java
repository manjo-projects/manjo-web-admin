package org.papaja.adminfly.module.psy.controller.test;

import org.papaja.adminfly.commons.ExtraHashMap;
import org.papaja.adminfly.module.psy.controller.AbstractPsyController;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.tests.mmpi2.Points;
import org.papaja.adminfly.module.psy.tests.mmpi2.calculation.Formula;
import org.papaja.adminfly.module.psy.tests.mmpi2.calculation.RawPointCalculator;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Answer;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Scale;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.ValueMap.Value;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

import static java.lang.String.format;
import static org.papaja.adminfly.module.psy.tests.Test.MMPI2_SOBCHIK;
import static org.papaja.adminfly.module.psy.tests.mmpi2.data.ValueMap.MAP;
import static org.papaja.adminfly.module.psy.tests.wizard.Wizard.State.FINISHED;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/psy/MMPI2_SOBCHIK")
public class MMPI2Controller extends AbstractPsyController {

    @Autowired
    @Qualifier("wizardMMPI2")
    private Wizard<Answer> wizard;

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping({"/restart"})
    public ModelAndView restart() {
        wizard.reset();

        return new ModelAndView(format("redirect:%s", getPrefix()));
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping({"", "/index"})
    public ModelAndView index() {
        ModelAndView mav = newView("test");

        wizard.update();

        if (!wizard.is(FINISHED) && context.getPatient().isOld()) {
            mav.addObject("prefix", getPrefix());
            mav.addObject("position", wizard.position());
            mav.addObject("total", wizard.size());
            mav.addObject("previous", wizard.results().get(wizard.position()));
        } else if (wizard.is(FINISHED)) {
            mav = newRedirect("calculate");
        } else {
            mav = newView("choose-patient");
            mav.addObject("items", patients.getAll());
            mav.addObject("test", MMPI2_SOBCHIK);
        }

        return mav;
    }

    @GetMapping({
            "/{direction:(?:FORWARD)+}/{answer:(?:F|T)+}",
            "/{direction:(?:BACKWARD)+}"
    })
    public ModelAndView submit(
            @PathVariable(value = "direction") Direction direction,
            @PathVariable(value = "answer", required = false) Answer answer,
            RedirectAttributes attributes
    ) {
        ModelAndView mav = new ModelAndView(format("redirect:%s", getPrefix()));

        if (!wizard.submit(answer, direction)) {
            attributes.addFlashAttribute("message",
                    messages.getWarningMessage("text.unableGoToStep", direction, wizard.position()));
        }

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping({"/calculate"})
    public ModelAndView calculate(
            RedirectAttributes attributes
    ) {
        ModelAndView mav = new ModelAndView("redirect:/psy/tests");

        if (wizard.results().size() == wizard.size()) {
            RawPointCalculator calculator = new RawPointCalculator();
            Points             points     = calculator.calculate(wizard.results());
            Formula            formula    = new Formula();
            Map<Scale, Value>  values     = MAP.getValues(context.getPatient().getSex());

            points.points().forEach((scale, integer) -> {
                Value value = values.get(scale);
                System.out.println(integer);
                System.out.println(scale);
                System.out.println(value.getIndex());
                System.out.println(value.getSigma());
                System.out.printf("%s - %s: RAW-%d; T-%s%n",
                        scale, scale.getKey(), integer, formula.apply(integer, value.getIndex(), value.getSigma()));
            });

            attributes.addFlashAttribute("message",
                    messages.getSuccessMessage("text.calculationResultWasSaved", MMPI2_SOBCHIK.getName()));

            // reset after calculation
            wizard.reset();
            context.setPatient(new Patient());
        } else {
            wizard.reset();
            attributes.addFlashAttribute("message",
                    messages.getErrorMessage("text.calculationNotReady"));
        }

        return mav;
    }

    @Controller
    @RequestMapping("/shared/psy/MMPI2_SOBCHIK")
    public static class Shared extends AbstractPsyController {

        @Autowired
        @Qualifier("wizardMMPI2")
        private Wizard<Answer> wizard;

        {
            setPrefix("/psy/MMPI2_SOBCHIK/shared");
        }

        @GetMapping
        public ModelAndView test() {
            ModelAndView mav = newView("index");

            ExtraHashMap.HOLDER.set("SHARED.metadata.name", "MMPI-2");

            wizard.update();

            if (context.getPatient().isNew()) {
                mav = new ModelAndView("redirect:/shared/psy/undefined");
            } else {
                mav.addObject("prefix", "/shared/psy/MMPI2_SOBCHIK");
                mav.addObject("position", wizard.position());
                mav.addObject("total", wizard.size());
                mav.addObject("previous", wizard.results().get(wizard.position()));
            }

            return mav;
        }

        @GetMapping({
                "/{direction:(?:FORWARD)+}/{answer:(?:F|T)+}",
                "/{direction:(?:BACKWARD)+}"
        })
        public ModelAndView submit(
                @PathVariable(value = "direction") Direction direction,
                @PathVariable(value = "answer", required = false) Answer answer,
                RedirectAttributes attributes
        ) {
            if (!wizard.submit(answer, direction)) {
                attributes.addFlashAttribute("message",
                        messages.getSuccessMessage("text.unableGoToStep", direction, wizard.position()));
            }

            return new ModelAndView(format("redirect:%s", "/shared/psy/MMPI2_SOBCHIK"));
        }

        @GetMapping({"/restart"})
        public ModelAndView restart() {
            wizard.reset();

            return new ModelAndView(format("redirect:/shared/psy/MMPI2_SOBCHIK"));
        }

    }

}
