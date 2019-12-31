package org.papaja.adminfly.module.psy.controller.test.MMPI;

import org.papaja.adminfly.module.psy.dbl.entity.results.AbstractMMPIResult;
import org.papaja.adminfly.module.psy.dbl.entity.results.MMPI71Result;
import org.papaja.adminfly.module.psy.tests.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.papaja.adminfly.module.psy.tests.Test.MMPI_71;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/MMPI_71")
public class MMPI71Controller extends AbstractMMPIController {

    @Override
    public Test getTest() {
        return MMPI_71;
    }

    @Override
    protected AbstractMMPIResult getResultEntity() {
        return new MMPI71Result();
    }

    @Controller
    @RequestMapping("/shared/MMPI_71")
    public static class Shared extends AbstractMMPIController.MMPIShared {

        @Override
        public Test getTest() {
            return MMPI_71;
        }

    }

}
