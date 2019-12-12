package org.papaja.adminfly.module.psy.controller.test.MMPI;

import org.papaja.adminfly.commons.DataHolder;
import org.papaja.adminfly.module.psy.controller.AbstractPsyController;
import org.papaja.adminfly.module.psy.dbl.converter.MMPI2ResultConverter;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.results.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.tests.TestAware;
import org.papaja.adminfly.module.psy.tests.MMPI.Answer;
import org.papaja.adminfly.module.psy.tests.MMPI.AnswersPointsConverter;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.MMPI.Q566.Formula;
import org.papaja.adminfly.module.psy.tests.MMPI.Q566.Questions;
import org.papaja.adminfly.module.psy.tests.MMPI.Q566.ValueMap;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.papaja.adminfly.module.psy.tests.wizard.WizardAware;
import org.papaja.tuple.Triplet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

import static java.lang.String.format;
import static org.papaja.adminfly.module.psy.tests.Test.MMPI_566;
import static org.papaja.adminfly.module.psy.tests.MMPI.Q566.ValueMap.MAP;
import static org.papaja.adminfly.module.psy.tests.wizard.Wizard.State.FINISHED;

@Controller
abstract public class AbstractMMPIController extends AbstractPsyController implements WizardAware, TestAware {

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping({"/restart"})
    public ModelAndView restart() {
        getWizard().reset();

        return new ModelAndView(format("redirect:%s", getPrefix()));
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping({"", "/index"})
    public ModelAndView index() {
        ModelAndView mav = newView("test");

        getWizard().update();

        if (!getWizard().is(FINISHED) && context.getPatient().isOld()) {
            mav.addObject("prefix", getPrefix());
            mav.addObject("position", getWizard().position());
            mav.addObject("total", getWizard().size());
            mav.addObject("previous", getWizard().results().get(getWizard().position()));
        } else if (getWizard().is(FINISHED)) {
            mav = newRedirect("calculate");
        } else {
            mav = newView("choose-patient");
            mav.addObject("items", patients.getAll());
            mav.addObject("test", getTest());
        }

        return mav;
    }

    @GetMapping({
            "/{direction:(?:FORWARD)+}/{answer:(?:F|T)+}",
            "/{direction:(?:BACKWARD)+}"
    })
    public ModelAndView submit(
            @PathVariable(value = "direction") Wizard.Direction direction,
            @PathVariable(value = "answer", required = false) Answer answer,
            RedirectAttributes attributes
    ) {
        ModelAndView mav = new ModelAndView(format("redirect:%s", getPrefix()));

        if (!getWizard().submit(answer, direction)) {
            attributes.addFlashAttribute("message",
                    messages.getWarningMessage("text.unableGoToStep", direction, getWizard().position()));
        }

        return mav;
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping({"/calculate"})
    public ModelAndView calculate(
            RedirectAttributes attributes
    ) {
        Wizard<Answer> wizard = getWizard();
        ModelAndView   mav    = new ModelAndView("redirect:/psy/tests");

        if (wizard.results().size() == wizard.size()) {
            AnswersPointsConverter     converter = new AnswersPointsConverter(new Questions());
            Map<Scale, Integer>        points    = converter.convert(wizard.results());
            Formula                    formula   = new Formula();
            Map<Scale, ValueMap.Value> values    = MAP.getValues(context.getPatient().getSex());

            AbstractMMPIResult result = new MMPI2ResultConverter()
                    .convert(new Triplet(getMMPI2ResultEntity(), points, context.getPatient()));

            results.merge(result);

            attributes.addFlashAttribute("message",
                    messages.getSuccessMessage("text.calculationResultWasSaved", MMPI_566.getName()));

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

    abstract protected AbstractMMPIResult getMMPI2ResultEntity();

    abstract public static class MMPI2Shared extends AbstractPsyController implements WizardAware, TestAware {

        @GetMapping
        public ModelAndView test() {
            Wizard<Answer> wizard = getWizard();
            ModelAndView   mav    = newView("index");

            DataHolder.HOLDER.set("main.name", getTest().getName());

            wizard.update();

            if (context.getPatient().isNew()) {
                mav = new ModelAndView("redirect:/shared/psy/undefined");
            } else {
                mav.addObject("prefix", format("/shared/psy/%s", getTest().name()));
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
                @PathVariable(value = "direction") Wizard.Direction direction,
                @PathVariable(value = "answer", required = false) Answer answer,
                RedirectAttributes attributes
        ) {
            Wizard<Answer> wizard = getWizard();

            if (!wizard.submit(answer, direction)) {
                attributes.addFlashAttribute("message",
                        messages.getSuccessMessage("text.unableGoToStep", direction, wizard.position()));
            }

            return new ModelAndView(format("redirect:%s", format("/shared/psy/%s", getTest().name())));
        }

        @GetMapping({"/restart"})
        public ModelAndView restart() {
            getWizard().reset();

            return new ModelAndView(format(format("redirect:/shared/psy/%s", getTest().name())));
        }

    }

}
