package org.papaja.adminfly.module.psy.controller.test.mmpi2;

import org.papaja.adminfly.module.psy.dbl.entity.results.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.dbl.entity.results.MMPI566Result;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.mmpi2.Answer;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.papaja.adminfly.module.psy.tests.Test.MMPI_566;

@SuppressWarnings({"unused", "Duplicates"})
@Controller
@RequestMapping("/psy/MMPI_566")
public class MMPI566Controller extends MMPI2Controller {

    @Autowired
    @Qualifier("wizardMMPI2")
    private Wizard<Answer> wizard;

    @Override
    public Wizard<Answer> getWizard() {
        return wizard;
    }

    @Override
    public Test getTest() {
        return MMPI_566;
    }

    @Override
    protected AbstractMMPIResult getMMPI2ResultEntity() {
        return new MMPI566Result();
    }

    @Controller
    @RequestMapping("/shared/psy/MMPI_566")
    public static class Shared extends MMPI2Controller.MMPI2Shared {

        @Autowired
        @Qualifier("wizardMMPI2")
        private Wizard<Answer> wizard;

        {
            setPrefix("/psy/MMPI_566/shared");
        }

        @Override
        public Wizard<Answer> getWizard() {
            return wizard;
        }

        @Override
        public Test getTest() {
            return MMPI_566;
        }

    }

}
