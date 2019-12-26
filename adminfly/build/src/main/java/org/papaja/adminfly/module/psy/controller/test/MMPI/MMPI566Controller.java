package org.papaja.adminfly.module.psy.controller.test.MMPI;

import org.papaja.adminfly.module.psy.dbl.entity.results.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.dbl.entity.results.MMPI566Result;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.MMPI.Answer;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.papaja.adminfly.module.psy.tests.Test.MMPI_566;

@SuppressWarnings({"unused", "Duplicates"})
@Controller
@RequestMapping("/MMPI_566")
public class MMPI566Controller extends AbstractMMPIController {

    @Override
    public Test getTest() {
        return MMPI_566;
    }

    @Override
    protected AbstractMMPIResult getResultEntity() {
        return new MMPI566Result();
    }

    @Controller
    @RequestMapping("/shared/MMPI_566")
    public static class Shared extends AbstractMMPIController.MMPI2Shared {

        @Override
        public Test getTest() {
            return MMPI_566;
        }

    }

}
