package org.papaja.adminfly.module.psy.controller.test.MMPI;

import org.papaja.adminfly.module.psy.dbl.entity.results.MMPI71Result;
import org.papaja.adminfly.module.psy.dbl.entity.results.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.MMPI.Answer;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.papaja.adminfly.module.psy.tests.Test.MMPI_71;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/psy/MMPI_71")
public class MMPI71Controller extends AbstractMMPIController {

    @Autowired
    @Qualifier("wizardMMPI2")
    private Wizard<Answer> wizard;

    @Override
    public Wizard<Answer> getWizard() {
        return wizard;
    }

    @Override
    public Test getTest() {
        return MMPI_71;
    }

    @Override
    protected AbstractMMPIResult getResultEntity() {
        return new MMPI71Result();
    }

    @Controller
    @RequestMapping("/shared/psy/MMPI_71")
    public static class Shared extends MMPI2Shared {

        @Autowired
        @Qualifier("wizardMMPI2")
        private Wizard<Answer> wizard;

        @Override
        public Wizard<Answer> getWizard() {
            return wizard;
        }

        @Override
        public Test getTest() {
            return MMPI_71;
        }

    }

}
