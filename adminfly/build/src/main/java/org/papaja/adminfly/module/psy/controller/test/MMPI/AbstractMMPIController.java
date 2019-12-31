package org.papaja.adminfly.module.psy.controller.test.MMPI;

import org.papaja.adminfly.module.psy.controller.AbstractPsyController;
import org.papaja.adminfly.module.psy.dbl.converter.MMPIResultConverter;
import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.results.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.tests.MMPI.Answer;
import org.papaja.adminfly.module.psy.tests.MMPI.AnswersPointsConverter;
import org.papaja.adminfly.module.psy.tests.MMPI.Q566.Q566Answers;
import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.adminfly.module.psy.tests.MMPI.WizardFactory;
import org.papaja.adminfly.module.psy.tests.TestAware;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.papaja.adminfly.module.psy.tests.wizard.WizardAware;
import org.papaja.tuple.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

import static java.lang.String.format;
import static org.papaja.adminfly.module.psy.tests.wizard.Wizard.State.FINISHED;

@Controller
abstract public class AbstractMMPIController extends AbstractPsyController implements WizardAware, TestAware {

    @Autowired
    protected WizardFactory wizardFactory;

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping({"/restart"})
    public ModelAndView restart() {
        getWizard().reset();

        return newRedirect(getTest().name());
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping
    public ModelAndView index() {
        ModelAndView mav = newView("MMPI/test");

        getWizard().update();

        mav.addObject("test", getTest());

        if (!getWizard().is(FINISHED) && context.getPatient().isOld()) {
            mav.addObject("position", getWizard().position());
            mav.addObject("total", getWizard().size());
            mav.addObject("previous", getWizard().results().get(getWizard().position()));
            mav.addObject("prefix", format("/%s", getTest()));
        } else if (getWizard().is(FINISHED)) {
            mav = newRedirect("calculate");
        } else {
            mav = newView("choose-patient");
            mav.addObject("items", patients.getAll());
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
        ModelAndView mav = newRedirect(getTest().name());

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
        ModelAndView   mav    = newRedirect("tests");

        if (wizard.results().size() == wizard.size()) {
            AnswersPointsConverter converter = new AnswersPointsConverter(new Q566Answers());
            Map<Scale, Integer>    points    = converter.convert(wizard.results());

            AbstractMMPIResult result = new MMPIResultConverter()
                    .convert(new Triplet(getResultEntity(), points, context.getPatient()));

            results.merge(result);

            attributes.addFlashAttribute("message",
                    messages.getSuccessMessage("text.calculationResultWasSaved", getTest().getName()));

            wizard.reset();
            context.setPatient(new Patient());
        } else {
            wizard.reset();
            attributes.addFlashAttribute("message",
                    messages.getErrorMessage("text.calculationNotReady"));
        }

        return mav;
    }

    @Override
    public Wizard<Answer> getWizard() {
        return wizardFactory.createWizard(getTest());
    }

    abstract protected AbstractMMPIResult getResultEntity();

    abstract public static class MMPIShared extends AbstractPsyController implements WizardAware, TestAware {

        @Autowired
        protected WizardFactory wizardFactory;

        @GetMapping
        public ModelAndView test() {
            Wizard<Answer> wizard = getWizard();
            ModelAndView   mav    = newView("MMPI/shared/test");

            extra.set("main.name", getTest().getName());

            wizard.update();

            if (context.getPatient().isNew()) {
                mav = newView("MMPI/shared/undefined");
            } else if (getWizard().is(FINISHED)) {
                mav = newView("MMPI/shared/finish");
            } else {
                mav.addObject("test", getTest());
                mav.addObject("useGender", false);
                mav.addObject("position", wizard.position());
                mav.addObject("total", wizard.size());
                mav.addObject("previous", wizard.results().get(wizard.position()));
                mav.addObject("prefix", format("/shared/%s", getTest()));
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

            return newRedirect(format("shared/%s", getTest().name()));
        }

        @GetMapping({"/restart"})
        public ModelAndView restart() {
            getWizard().reset();

            return newRedirect(format("shared/%s", getTest().name()));
        }

        @Override
        public Wizard<Answer> getWizard() {
            return wizardFactory.createWizard(getTest());
        }

    }

}
