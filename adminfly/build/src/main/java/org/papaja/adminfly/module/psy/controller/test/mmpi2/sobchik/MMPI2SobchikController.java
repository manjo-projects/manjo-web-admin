package org.papaja.adminfly.module.psy.controller.test.mmpi2.sobchik;

import org.papaja.adminfly.module.psy.controller.test.mmpi2.MMPI2Controller;
import org.papaja.adminfly.module.psy.dbl.converter.MMPI2SobchikConverter;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.results.MMPI2SobchikResult;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.mmpi2.Points;
import org.papaja.adminfly.module.psy.tests.mmpi2.calculation.Formula;
import org.papaja.adminfly.module.psy.tests.mmpi2.calculation.RawPointCalculator;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Answer;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Scale;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.ValueMap.Value;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.papaja.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

import static org.papaja.adminfly.module.psy.tests.Test.MMPI2_SOBCHIK;
import static org.papaja.adminfly.module.psy.tests.mmpi2.data.ValueMap.MAP;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/psy/MMPI2_SOBCHIK")
public class MMPI2SobchikController extends MMPI2Controller {

    @Autowired
    @Qualifier("wizardMMPI2")
    private Wizard<Answer> wizard;

    @Override
    public Wizard<Answer> getWizard() {
        return wizard;
    }

    @Override
    public Test getTest() {
        return MMPI2_SOBCHIK;
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

            MMPI2SobchikResult result = new MMPI2SobchikConverter().convert(new Pair<>(points, context.getPatient()));

            results.merge(result);

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
    public static class Shared extends MMPI2Controller.MMPI2Shared {

        @Autowired
        @Qualifier("wizardMMPI2")
        private Wizard<Answer> wizard;

        {
            setPrefix("/psy/MMPI2_SOBCHIK/shared");
        }

        @Override
        public Wizard<Answer> getWizard() {
            return wizard;
        }

        @Override
        public Test getTest() {
            return MMPI2_SOBCHIK;
        }

    }

}
